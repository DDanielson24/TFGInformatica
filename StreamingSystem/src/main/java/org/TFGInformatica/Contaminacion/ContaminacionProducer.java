package org.TFGInformatica.Contaminacion;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.TFGInformatica.ContaminacionEstacionDeMedicion;
import org.TFGInformatica.Logs.LogWriter;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ContaminacionProducer {

    public static void main(String[] args) {

        //Crear las propiedades necesarias para el productor
        //UBUNTU VIRTUAL BOX
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "10.0.2.15:9092"); //Broker 0 del cluster
        props.setProperty("bootstrap.servers", "10.0.2.15:9093"); //Broker 1 del cluster
        props.setProperty("bootstrap.servers", "10.0.2.15:9094"); //Broker 2 del cluster
        props.setProperty("key.serializer", StringSerializer.class.getName());
        props.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
        props.setProperty("schema.registry.url", "http://10.0.2.15:8081");

        //Creamos el productor y el WatchService en el directorio data, además de la clase para los logs
        KafkaProducer<String, ContaminacionEstacionDeMedicion> contaminacionProducer = new KafkaProducer<String, ContaminacionEstacionDeMedicion>(props);
        LogWriter logWriter = new LogWriter("/home/daniel/Escritorio/TFGInformatica/Logs/Contaminacion/contaminacionProducerLogs");
        System.out.println("El productor ha sido creado. Analizando el directorio data para actualizaciones...");

        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path path = Paths.get("/home/daniel/Escritorio/TFGInformatica/StreamingSystem/data/");
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY);
            WatchKey key;

            //Bucle en el que el productor estará atento a si su fichero de datos ha sido actualizado
            while (true) {
                if ((key = watchService.take()) != null) {
                    for (WatchEvent<?> event : key.pollEvents()) {

                        //Timeout para esperar a que el fichero termine de ser descargado
                        TimeUnit.SECONDS.sleep(15);

                        if (event.context().toString().endsWith("ficheroContaminacion.xml")) {
                            //El fichero de datos ha sido actualizado
                            System.out.println("WatchService: El fichero " + event.context() + " ha sido actualizado");

                            //Por tanto, se procesa el nuevo fichero realizando las transformaciones necesarias
                            System.out.println("Comienza la lectura del archivo XML");
                            ContaminacionXMLReader xmlReader = new ContaminacionXMLReader("/home/daniel/Escritorio/TFGInformatica/StreamingSystem/data/ficheroContaminacion.xml");
                            List<ContaminacionEstacionDeMedicion> listaEMs = xmlReader.readXML();

                            System.out.println("EstacionesDeMedicion leídos del archivo XML: " + listaEMs.size());

                            //Se envía la lista de PMs
                            for (ContaminacionEstacionDeMedicion em : listaEMs) {
                                ProducerRecord<String, ContaminacionEstacionDeMedicion> producerRecord = new ProducerRecord<>("contaminacionData", String.valueOf(em.getIdelem()), em);
                                contaminacionProducer.send(producerRecord);
                                contaminacionProducer.flush();
                            }

                            //Actualizamos el archivo de logs de TraficoProducer
                            logWriter.writeLog("Se han enviado " + listaEMs.size() + " EstacionesDeMedicion");
                        }
                    }
                    key.reset();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            contaminacionProducer.close();
        }
    }
}
