package com.example.kafka.controller;

import com.example.kafka.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    KafkaTemplate<String, Book> kafkaTemplate;
    @Value("${plain-topic-name}")
    private String TOPIC;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Book book)
    {
        kafkaTemplate.send(TOPIC, book);
        return "Published Successfully!";
    }
}
