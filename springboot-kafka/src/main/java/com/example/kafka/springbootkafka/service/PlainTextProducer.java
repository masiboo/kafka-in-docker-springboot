package com.example.kafka.springbootkafka.service;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PlainTextProducer {
    @Value("${plain-topic-name}")
    private String TOPIC;
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        this.kafkaTemplate.send(TOPIC,message);
    }

    @Bean(name = "plainTopic")
    public NewTopic createTopic(){
        return new NewTopic(TOPIC,3,(short) 1);
    }



}
