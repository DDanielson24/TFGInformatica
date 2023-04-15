package org.TFGInformatica.Gasolina;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.TFGInformatica.PuntoDeMedicion;
import org.TFGInformatica.Trafico.XMLReader;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.List;
import java.util.Properties;

import org.TFGInformatica.EstacionDeServicio;

public class GasolinaProducer {

    public static void main(String[] args) {

        /*//1. Ejecutar el script pullRepo.sh que hará el git pull al repositorio remoto
        try {
            ProcessBuilder pb = new ProcessBuilder("/home/daniel/Escritorio/TFGInformatica/pullRepo.sh");
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("Script pullRepo.sh: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //3. Crear el productor de Kafka y enviar a través del topic
        //Creamos las propiedades necesarias para el Productor
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "192.168.0.37:9092");
        props.setProperty("key.serializer", StringSerializer.class.getName());
        props.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
        props.setProperty("schema.registry.url", "http://192.168.0.37:8081");

        //Creamos el productor y el WatchService en el directorio data - NO EN PRODUCCIÓN AÚN
        KafkaProducer<String, EstacionDeServicio> gasolinaProducer = new KafkaProducer<String, EstacionDeServicio>(props);
        System.out.println("El productor ha sido creado. Analizando el directorio data para actualizaciones...");

        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path path = Paths.get("/home/daniel/Escritorio/TFGInformatica/StreamingSystem/data/");
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
            WatchKey key;

            //Bucle en el que el productor estará atento a si su fichero de datos ha sido actualizado
            while(true) {
                if ((key = watchService.take()) != null) {
                    for (WatchEvent<?> event: key.pollEvents()) {
                        if (event.context().toString().endsWith("ficheroGasolina.xls")) {
                            //El fichero de datos ha sido actualizado
                            System.out.println("WatchService: El fichero " + event.context() + " ha sido actualizado");

                            //Por tanto, se procesa el nuevo fichero
                            //2. Leer el archivo realizando las transformaciones necesarias
                            System.out.println("Comienza la lectura del archivo XLS");
                            XLSReader xmlReader = new XLSReader("/home/daniel/Escritorio/TFGInformatica/StreamingSystem/data/ficheroGasolina.xls");
                            List<EstacionDeServicio> listaEDSs = xmlReader.readXLS();

                            System.out.println("La longitud de la lista es: " + listaEDSs.size());

                            //Se envía la lista de EDSs
                            for (EstacionDeServicio es: listaEDSs) {

                                ProducerRecord<String, EstacionDeServicio> producerRecord = new ProducerRecord<>("gasolinaData", es);
                                gasolinaProducer.send(producerRecord);
                                gasolinaProducer.flush();

                            }
                        }
                    }
                    key.reset();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        gasolinaProducer.close();

    }
}
