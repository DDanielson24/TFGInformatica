#!/bin/sh
#
# 1. Zookeeper
/home/daniel/confluent-7.3.2/bin/zookeeper-server-start /home/daniel/confluent-7.3.2/etc/kafka/zookeeper.properties & 
/home/daniel/confluent-7.3.2/bin/kafka-server-start /home/daniel/confluent-7.3.2/etc/kafka/server.properties &
/home/daniel/confluent-7.3.2/bin/schema-registry-start /home/daniel/confluent-7.3.2/etc/schema-registry/schema-registry.properties
