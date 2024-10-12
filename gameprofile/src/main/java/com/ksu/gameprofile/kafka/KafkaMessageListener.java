package com.ksu.gameprofile.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ksu.gameprofile.model.CustomerAchievement;
import com.ksu.gameprofile.service.CustomerGameProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaMessageListener {

    private final ObjectMapper objectMapper;
    public static final String TOPIC_ACHIEVEMENT = "achievement";
    @Autowired
    private CustomerGameProfileService customerGameProfileService;

    @KafkaListener(topics = TOPIC_ACHIEVEMENT)
    public void receiveMessage(@Payload String message) {
        CustomerAchievement customerAchievement;
        try {
            customerAchievement = objectMapper.readValue(message, CustomerAchievement.class);
        } catch (Exception e) {
            log.error(e.getMessage());
            return;
        }
        log.info("Received message {}", customerAchievement);
        customerGameProfileService.process(customerAchievement);
    }
}
