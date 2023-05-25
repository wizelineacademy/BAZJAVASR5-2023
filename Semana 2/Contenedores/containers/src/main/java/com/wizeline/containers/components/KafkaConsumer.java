package com.wizeline.containers.components;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "messageTopic" , groupId = "messageGroup")
    public void consume(String message) {
        System.out.println("Consuming message: " + message);
    }
}
