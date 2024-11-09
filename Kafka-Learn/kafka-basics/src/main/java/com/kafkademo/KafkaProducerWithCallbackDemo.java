package com.kafkademo;


import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.StringJoiner;

public class KafkaProducerWithCallbackDemo {

    public static final Logger log = LoggerFactory.getLogger(KafkaProducerWithCallbackDemo.class);

    public static void main(String[] args) throws InterruptedException {

        log.info("TestProducer main method");
        String bootstrapServers = "localhost:9092";
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty("batch.size","400");

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        for(int j=0;j<10;j++) {
            for(int i=3;i<11;i++){
                ProducerRecord<String, String> records = new ProducerRecord<>("first_topic", "This is " + i + "th Java Kafka Message");
                producer.send(records, (recordMetadata, e) -> {
                    if(e == null) {
                        String topicDescriptor = "Topic ->".concat(recordMetadata.topic())
                                .concat("\n Partition -> ")
                                .concat(String.valueOf(recordMetadata.partition()))
                                .concat("\nOffset -> ")
                                .concat(String.valueOf(recordMetadata.offset()));
                        log.info("Record received - \n {}", topicDescriptor);
                    }
                });
                Thread.sleep(500);
                producer.flush();
            }
        }


        producer.close();
    }
}
