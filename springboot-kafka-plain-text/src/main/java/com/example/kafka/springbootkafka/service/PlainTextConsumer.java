package com.example.kafka.springbootkafka.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PlainTextConsumer {

    @Value("${plain-topic-name}")
    private String topicName;
    @KafkaListener(topics = "${plain-topic-name}", groupId = "group_id_ma")
    public void consumeMessage(String message){
        System.out.println("Received message from topic " + topicName + ": " + message);
    }
}
