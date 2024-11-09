package com.kafkademo;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class KafkaProducerWithKeysDemo {

    public static final Logger log = LoggerFactory.getLogger(KafkaProducerWithKeysDemo.class);

    public static void main(String[] args) throws InterruptedException {

        log.info("TestProducer main method");
        KafkaProducer<String, String> producer = getStringStringKafkaProducer();
        for(int j=0;j<5;j++) {
            for(int i=1;i<10;i++){
                String topic = "first_topic";
                String key = "id_"+i;
                String message = "message to kafka -> "+i;
                ProducerRecord<String, String> records = new ProducerRecord<>(topic ,key, message);
                producer.send(records, (recordMetadata, e) -> {
                    if(e == null) {
                        String topicDescriptor = "Topic ->".concat(recordMetadata.topic())
                                .concat("\n Partition -> ")
                                .concat(String.valueOf(recordMetadata.partition()))
                                .concat("\n key -> ")
                                .concat(key);
                        log.info("Record received - \n {}", topicDescriptor);
                    }
                });
                Thread.sleep(500);
                producer.flush();
            }
        }
        producer.close();
    }

    private static KafkaProducer<String, String> getStringStringKafkaProducer() {
        String bootstrapServers = "localhost:9092";
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
       return new KafkaProducer<>(properties);
    }
}
