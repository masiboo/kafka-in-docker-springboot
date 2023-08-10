package com.example.kafka.springbootkafka.controller;

import com.example.kafka.springbootkafka.service.PlainTextProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlainTextController {

    private final PlainTextProducer producer;

    @Autowired
    public PlainTextController(PlainTextProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publishText")
    public void messageToTopic(@RequestParam("message") String message){

        this.producer.sendMessage(message);


    }
}
