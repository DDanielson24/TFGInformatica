#!/bin/sh
#
# 1. Zookeeper
/home/daniel/confluent-7.3.2/bin/zookeeper-server-start /home/daniel/confluent-7.3.2/etc/kafka/zookeeper.properties & 

# 2. Kafka Server
#Broker 0
/home/daniel/confluent-7.3.2/bin/kafka-server-start /home/daniel/confluent-7.3.2/etc/kafka/server.broker0.properties &
/home/daniel/confluent-7.3.2/bin/kafka-server-start /home/daniel/confluent-7.3.2/etc/kafka/server.broker1.properties &
/home/daniel/confluent-7.3.2/bin/kafka-server-start /home/daniel/confluent-7.3.2/etc/kafka/server.broker2.properties &

# 3. Schema Registry
/home/daniel/confluent-7.3.2/bin/schema-registry-start /home/daniel/confluent-7.3.2/etc/schema-registry/schema-registry.properties
