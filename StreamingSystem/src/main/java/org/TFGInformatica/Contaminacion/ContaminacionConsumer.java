package org.TFGInformatica.Contaminacion;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.TFGInformatica.ContaminacionEstacionDeMedicion;
import org.TFGInformatica.Logs.LogWriter;
import org.TFGInformatica.PostgreSQL.PSQLConnectionContaminacion;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ContaminacionConsumer {

    public static void main(String[] args) {

        //Crear las propiedades necesarias para el consumidor
        //UBUNTU VIRTUAL BOX
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "10.0.2.15:9092"); //Broker 0 del cluster
        props.setProperty("bootstrap.servers", "10.0.2.15:9093"); //Broker 1 del cluster
        props.setProperty("bootstrap.servers", "10.0.2.15:9094"); //Broker 2 del cluster
        props.setProperty("key.deserializer", StringDeserializer.class.getName());
        props.setProperty("value.deserializer", KafkaAvroDeserializer.class.getName());
        props.setProperty("group.id", "contaminacionConsumerGroup");
        props.setProperty("auto.offset.reset", "latest");
        props.setProperty("specific.avro.reader", "true");
        props.setProperty("schema.registry.url", "http://10.0.2.15:8081");

        //Creamos el consumidor, nos suscribimos y leemos los PM, además de la clase para los logs
        KafkaConsumer<String, ContaminacionEstacionDeMedicion> contaminacionConsumer = new KafkaConsumer<String, ContaminacionEstacionDeMedicion>(props);
        contaminacionConsumer.subscribe(Arrays.asList("contaminacionData"));
        LogWriter logWriter = new LogWriter("/home/daniel/Escritorio/TFGInformatica/Logs/Contaminacion/contaminacionConsumerLogs");

        //Creamos la clase para conectarse a la BD y nos conectamos
        PSQLConnectionContaminacion psqlConnectionContaminacion = new PSQLConnectionContaminacion();
        psqlConnectionContaminacion.connect();

        try {
            while (true) {
                ConsumerRecords<String, ContaminacionEstacionDeMedicion> records = contaminacionConsumer.poll(Duration.ofMillis(100));

                //Actualizamos el archivo de logs de ContaminacionConsumer
                if (records.count() != 0) {
                    logWriter.writeLog("Se han recibido " + records.count() + " EstacionesDeMedicion");
                }

                for (ConsumerRecord<String, ContaminacionEstacionDeMedicion> record: records) {

                    //Para cada EM, enviar a la base de datos
                    ContaminacionEstacionDeMedicion em = record.value();
                    System.out.println("EstacionDeMedicion: " + em.toString() + " recibido exitosamente");

                    //Llamamos al método para añadir filas a la BD
                    psqlConnectionContaminacion.addRow(em);

                }
            }
        } finally {
            contaminacionConsumer.close();
        }
    }
}
