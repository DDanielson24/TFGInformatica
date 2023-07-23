package org.TFGInformatica.Trafico;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.TFGInformatica.PostgreSQL.CoordConverter;
import org.TFGInformatica.TraficoPuntoDeMedicion;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

import org.TFGInformatica.TraficoPuntoDeMedicion;

public class TraficoProducer {

    public static void main(String[] args) {

        //3. Crear el productor de Kafka y enviar a través del topic
        //Creamos las propiedades necesarias para el Productor
        //UBUNTU VIRTUAL BOX
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "10.0.2.15:9092");
        props.setProperty("key.serializer", StringSerializer.class.getName());
        props.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
        props.setProperty("schema.registry.url", "http://10.0.2.15:8081");

        //KALI LINUX
        /*Properties props = new Properties();
        props.setProperty("bootstrap.servers", "192.168.0.37::9092");
        props.setProperty("key.serializer", StringSerializer.class.getName());
        props.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
        props.setProperty("schema.registry.url", "https://192.168.0.37::8081");*/

        //Creamos el productor y el WatchService en el directorio data
        KafkaProducer<String, TraficoPuntoDeMedicion> traficoProducer = new KafkaProducer<String, TraficoPuntoDeMedicion>(props);
        System.out.println("El productor ha sido creado. Analizando el directorio data para actualizaciones...");

        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path path = Paths.get("/home/daniel/Escritorio/TFGInformatica/StreamingSystem/data/");
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY);
            WatchKey key;

            //Bucle en el que el productor estará atento a si su fichero de datos ha sido actualizado
            while(true) {
                if ((key = watchService.take()) != null) {
                    for (WatchEvent<?> event: key.pollEvents()) {

                        //Timeout para esperar a que el fichero termine de ser descargado
                        TimeUnit.SECONDS.sleep(15);

                        if (event.context().toString().endsWith("ficheroTrafico.xml")) {
                            //El fichero de datos ha sido actualizado
                            System.out.println("WatchService: El fichero " + event.context() + " ha sido actualizado");

                            //Por tanto, se procesa el nuevo fichero
                            //2. Leer el archivo realizando las transformaciones necesarias
                            System.out.println("Comienza la lectura del archivo XML");
                            TraficoXMLReader xmlReader = new TraficoXMLReader("/home/daniel/Escritorio/TFGInformatica/StreamingSystem/data/ficheroTrafico.xml", "/home/daniel/Escritorio/TFGInformatica/StreamingSystem/data/ficheroPuntosTrafico.csv");
                            List<TraficoPuntoDeMedicion> listaPMs = xmlReader.readXML();

                            System.out.println("La longitud de la lista es: " + listaPMs.size());

                            //Se envía la lista de PMs
                            for (TraficoPuntoDeMedicion pm: listaPMs) {

                                ProducerRecord<String, TraficoPuntoDeMedicion> producerRecord = new ProducerRecord<>("traficoData", pm);
                                traficoProducer.send(producerRecord);
                                traficoProducer.flush();

                            }
                        }
                    }
                    key.reset();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        traficoProducer.close();
    }
}
