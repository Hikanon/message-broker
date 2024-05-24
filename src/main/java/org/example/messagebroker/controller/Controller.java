package org.example.messagebroker.controller;

import org.example.messagebroker.dto.MessageDto;
import org.example.messagebroker.kafka.Producer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final Producer producer;

    public Controller(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/")
    public MessageDto sendMessage(@RequestBody MessageDto message) {
        producer.send(message);
        return message;
    }

}
