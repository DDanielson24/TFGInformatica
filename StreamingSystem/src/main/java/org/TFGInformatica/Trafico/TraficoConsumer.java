package org.TFGInformatica.Trafico;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.TFGInformatica.TraficoPuntoDeMedicion;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.TFGInformatica.PostgreSQL.PSQLConnectionTrafico;
import org.TFGInformatica.TraficoPuntoDeMedicion;

public class TraficoConsumer {

    public static void main(String[] args) {

        //1. Crear el consumidor de Kafka y leer a través del topic
        //Creamos las propiedades necesarias para el consumidor
        //UBUNTU VIRTUAL BOX
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "10.0.2.15:9092");
        props.setProperty("key.deserializer", StringDeserializer.class.getName());
        props.setProperty("value.deserializer", KafkaAvroDeserializer.class.getName());
        props.setProperty("group.id", "traficoConsumerGroup");
        props.setProperty("auto.offset.reset", "latest");
        props.setProperty("specific.avro.reader", "true");
        props.setProperty("schema.registry.url", "http://10.0.2.15:8081");

        //KALI LINUX
        /*Properties props = new Properties();
        props.setProperty("bootstrap.servers", "192.168.0.33:9092");
        props.setProperty("key.deserializer", StringDeserializer.class.getName());
        props.setProperty("value.deserializer", KafkaAvroDeserializer.class.getName());
        props.setProperty("group.id", "traficoConsumerGroup");
        props.setProperty("auto.offset.reset", "latest");
        props.setProperty("specific.avro.reader", "true");
        props.setProperty("schema.registry.url", "http://192.168.0.33:8081");*/

        //Creamos el consumidor, nos suscribimos y leemos los PM
        KafkaConsumer<String, TraficoPuntoDeMedicion> traficoConsumer = new KafkaConsumer<String, TraficoPuntoDeMedicion>(props);
        traficoConsumer.subscribe(Arrays.asList("traficoData"));

        //Creamos la clase para conectarse a la BD y nos conectamos
        PSQLConnectionTrafico psqlConnectionTrafico = new PSQLConnectionTrafico();
        psqlConnectionTrafico.connect();

        try {

            while (true) {
                ConsumerRecords<String, TraficoPuntoDeMedicion> records = traficoConsumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, TraficoPuntoDeMedicion> record: records) {

                    //2. Para cada PM, comprobar que no hay error y enviar a la base de datos
                    TraficoPuntoDeMedicion pm = record.value();
                    System.out.println("PuntoDeMedicion: " + pm.toString() + " recibido exitosamente");

                    //Llamamos al método para añadir filas a la BD
                    psqlConnectionTrafico.addRow(pm);

                }
            }

        } finally {
            traficoConsumer.close();
        }

    }

}
