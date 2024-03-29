package org.TFGInformatica.Trafico;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.TFGInformatica.Logs.LogWriter;
import org.TFGInformatica.TraficoPuntoDeMedicion;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.TFGInformatica.PostgreSQL.PSQLConnectionTrafico;

public class TraficoConsumer {

    public static void main(String[] args) {

        //Crear las propiedades necesarias para el consumidor
        //UBUNTU VIRTUAL BOX
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "10.0.2.15:9092"); //Broker 0 del cluster
        props.setProperty("bootstrap.servers", "10.0.2.15:9093"); //Broker 1 del cluster
        props.setProperty("bootstrap.servers", "10.0.2.15:9094"); //Broker 2 del cluster
        props.setProperty("key.deserializer", StringDeserializer.class.getName());
        props.setProperty("value.deserializer", KafkaAvroDeserializer.class.getName());
        props.setProperty("group.id", "traficoConsumerGroup");
        props.setProperty("auto.offset.reset", "latest");
        props.setProperty("specific.avro.reader", "true");
        props.setProperty("schema.registry.url", "http://10.0.2.15:8081");

        //Creamos el consumidor, nos suscribimos y leemos los PM
        KafkaConsumer<String, TraficoPuntoDeMedicion> traficoConsumer = new KafkaConsumer<String, TraficoPuntoDeMedicion>(props);
        traficoConsumer.subscribe(Arrays.asList("traficoData"));
        LogWriter logWriter = new LogWriter("/home/daniel/Escritorio/TFGInformatica/Logs/Trafico/traficoConsumerLogs");

        //Creamos la clase para conectarse a la BD y nos conectamos
        PSQLConnectionTrafico psqlConnectionTrafico = new PSQLConnectionTrafico();
        psqlConnectionTrafico.connect();

        try {
            while (true) {
                ConsumerRecords<String, TraficoPuntoDeMedicion> records = traficoConsumer.poll(Duration.ofMillis(100));

                //Actualizamos el archivo de logs de ContaminacionConsumer cuando se hayan procesado todos los records
                if (records.count() != 0) {
                    logWriter.writeLog("Se han recibido " + records.count() + " PuntosDeMedicion");
                }

                for (ConsumerRecord<String, TraficoPuntoDeMedicion> record: records) {

                    //Para cada PM, enviar a la base de datos
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
