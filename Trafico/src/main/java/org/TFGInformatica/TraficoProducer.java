package org.TFGInformatica;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

public class TraficoProducer {

    public static void main(String[] args) {

        //1. Ejecutar el script pullRepo.sh que hará el git pull al repositorio remoto
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
        }

        //2. Leer el archivo realizando las transformaciones necesarias
        System.out.println("Comienza la lectura del archivo XML");
        XMLReader xmlReader = new XMLReader("/home/daniel/Escritorio/TFGInformatica/Trafico/TraficoProducer/data/ficheroTrafico.xml");
        List<PuntoDeMedicion> listaPMs = xmlReader.readXML();

        System.out.println("La longitud de la lista es: " + listaPMs.size());

        //3. Crear el productor de Kafka y enviar a través del topic
        //Creamos las propiedades necesarias para el Productor
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "192.168.0.24:9092");
        props.setProperty("key.serializer", StringSerializer.class.getName());
        props.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
        props.setProperty("schema.registry.url", "http://192.168.0.24:8081");

        //Creamos el productor y enviamos el PM
        KafkaProducer<String, PuntoDeMedicion> traficoProducer = new KafkaProducer<String, PuntoDeMedicion>(props);
        for (PuntoDeMedicion pm: listaPMs) {

            ProducerRecord<String, PuntoDeMedicion> producerRecord = new ProducerRecord<>("traficoData", pm);
            traficoProducer.send(producerRecord);
            traficoProducer.flush();

        }

        traficoProducer.close();
    }
}