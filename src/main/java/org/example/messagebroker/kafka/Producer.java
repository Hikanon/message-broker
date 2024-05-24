package org.example.messagebroker.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.example.messagebroker.dto.MessageDto;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final String TOPIC = "test_topic";

    private final KafkaTemplate<String, MessageDto> kafkaTemplate;

    public Producer(KafkaTemplate<String, MessageDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(MessageDto message) {
        kafkaTemplate.send(TOPIC, message);
    }

    @Bean
    public NewTopic createTopic(){
        return new NewTopic(TOPIC,3,(short) 1);
    }

}
