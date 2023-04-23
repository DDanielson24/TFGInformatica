package org.TFGInformatica.Gasolina;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.TFGInformatica.PostgreSQL.PSQLConnectionGasolina;
import org.TFGInformatica.PuntoDeMedicion;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.TFGInformatica.EstacionDeServicio;

public class GasolinaConsumer {

    public static void main(String[] args) {

        //1. Crear el consumidor de Kafka y leer a través del topic
        //Creamos las propiedades necesarias para el consumidor
        //UBUNTU VIRTUAL BOX
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "10.0.2.15:9092");
        props.setProperty("key.deserializer", StringDeserializer.class.getName());
        props.setProperty("value.deserializer", KafkaAvroDeserializer.class.getName());
        props.setProperty("group.id", "gasolinaConsumerGroup");
        props.setProperty("auto.offset.reset", "latest");
        props.setProperty("specific.avro.reader", "true");
        props.setProperty("schema.registry.url", "http://10.0.2.15:8081");

        //KALI LINUX
        /*Properties props = new Properties();
        props.setProperty("bootstrap.servers", "192.168.0.33:9092");
        props.setProperty("key.deserializer", StringDeserializer.class.getName());
        props.setProperty("value.deserializer", KafkaAvroDeserializer.class.getName());
        props.setProperty("group.id", "gasolinaConsumerGroup");
        props.setProperty("auto.offset.reset", "latest");
        props.setProperty("specific.avro.reader", "true");
        props.setProperty("schema.registry.url", "http://192.168.0.33:8081");*/

        //Creamos el consumidor, nos suscribimos y leemos las ES
        KafkaConsumer<String, EstacionDeServicio> gasolinaConsumer = new KafkaConsumer<String, EstacionDeServicio>(props);
        gasolinaConsumer.subscribe(Arrays.asList("gasolinaData"));

        //Creamos la clase para conectarse a la BD y nos conectamos
        PSQLConnectionGasolina psqlConnectionGasolina = new PSQLConnectionGasolina();
        psqlConnectionGasolina.connect();

        try {

            while(true) {
                ConsumerRecords<String, EstacionDeServicio> records = gasolinaConsumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, EstacionDeServicio> record: records) {

                    //2. Para cada ES, comprobar que no hay error y enviar a la base de datos
                    EstacionDeServicio es = record.value();
                    System.out.println("EstacionDeServicio: " + es.getRotulo() + ", " + es.getDireccion() +
                            ", " + es.getMargen() + ", " + es.getMunicipio() + " recibido exitosamente");

                    //Llamamos al método para añadir filas a la BD
                    psqlConnectionGasolina.addRow(es);

                }
            }

        } finally {
            gasolinaConsumer.close();
        }

    }
}
