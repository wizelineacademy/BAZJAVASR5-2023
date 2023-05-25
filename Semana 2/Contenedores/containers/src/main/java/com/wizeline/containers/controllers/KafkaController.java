package com.wizeline.containers.controllers;

import com.wizeline.containers.components.KafkaProducer;
import com.wizeline.containers.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/message")
    public ResponseEntity<Message> message(@RequestParam String message) {
        String responseMessage = "Consumed " + message;
        kafkaProducer.sendMessage(message);
        return new ResponseEntity<>(new Message("Kafka message", responseMessage, "Thanks!"),
                HttpStatusCode.valueOf(200));
    }
}
