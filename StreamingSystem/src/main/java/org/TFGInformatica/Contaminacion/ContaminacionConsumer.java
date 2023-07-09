package org.TFGInformatica.Contaminacion;

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

public class ContaminacionConsumer {

    public static void main(String[] args) {

        //1. Crear el consumidor de Kafka y leer a través del topic
        //Creamos las propiedades necesarias para el consumidor
        //UBUNTU VIRTUAL BOX
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "10.0.2.15:9092");
        props.setProperty("key.deserializer", StringDeserializer.class.getName());
        props.setProperty("value.deserializer", KafkaAvroDeserializer.class.getName());
        props.setProperty("group.id", "contaminacionConsumerGroup");
        props.setProperty("auto.offset.reset", "latest");
        props.setProperty("specific.avro.reader", "true");
        props.setProperty("schema.registry.url", "http://10.0.2.15:8081");

        //KALI LINUX
        /*Properties props = new Properties();
        props.setProperty("bootstrap.servers", "192.168.0.33:9092");
        props.setProperty("key.deserializer", StringDeserializer.class.getName());
        props.setProperty("value.deserializer", KafkaAvroDeserializer.class.getName());
        props.setProperty("group.id", "contaminacionConsumerGroup");
        props.setProperty("auto.offset.reset", "latest");
        props.setProperty("specific.avro.reader", "true");
        props.setProperty("schema.registry.url", "http://192.168.0.33:8081");*/

    }
}
