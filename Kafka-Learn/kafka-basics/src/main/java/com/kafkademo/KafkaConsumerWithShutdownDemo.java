package com.kafkademo;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerWithShutdownDemo {

    public static final Logger log = LoggerFactory.getLogger(KafkaConsumerWithShutdownDemo.class);

    public static void main(String[] args) {

        log.info("TestConsumer main method");
        KafkaConsumer<String, String> consumer = getKafkaConsumer();

        Thread mainThread = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                consumer.wakeup();
                try {
                    mainThread.join();
                } catch (InterruptedException e) {
                    log.info("Unexpected Exception occurred -> {}", e.getMessage());
                }
            }
        });
        try {
            consumer.subscribe(Collections.singletonList("first_topic"));
            while(true) {
                log.info("Pooling");
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, String> cRecord : records) {
                    log.info("cRecord key -> {}, cRecord value -> {}", cRecord.key(), cRecord.value());
                    log.info("cRecord partition -> {}, cRecord offset -> {}", cRecord.partition(), cRecord.offset());
                }
            }
        } catch (WakeupException we) {
            log.info("Consumer is shutting down.....!");
        } catch (Exception e) {
            log.info("Unexpected Exception occurred.....!");
        } finally {
            consumer.close();
            log.info("Consumer is gracefully shut down.....!");
        }
    }

    private static KafkaConsumer<String, String> getKafkaConsumer() {
        String bootstrapServers = "localhost:9092";
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "my-java-kafka-demo");
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return new KafkaConsumer<>(properties);
    }
}
