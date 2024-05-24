package org.example.messagebroker.kafka;

import org.example.messagebroker.dto.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    private static final String MESSAGE_TEMPLATE = "Received message from topic: %s, group id: %s. Message %s";

    @KafkaListener(topics = "test_topic", groupId = "group_id")
    public void consumeMessage(MessageDto message) {
        String formatted = String.format(MESSAGE_TEMPLATE, "test_topic", "group_id", message);
        LOGGER.info(formatted);
    }

}
