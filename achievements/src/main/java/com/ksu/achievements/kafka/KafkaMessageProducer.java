package com.ksu.achievements.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ksu.achievements.model.CustomerAchievement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaMessageProducer {

    public static final String TOPIC_ACHIEVEMENT = "achievement";

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper mapper;

    public void sendRequestMessage(CustomerAchievement customerAchievement) {
        log.info("achievement = {}", customerAchievement.getId());
        kafkaTemplate.send(TOPIC_ACHIEVEMENT, String.valueOf(customerAchievement.getCustomerId()), convertToString(customerAchievement));
    }

    private String convertToString(Object dto) {
        try {
            return mapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(
                    "An error occurred while converting JSON = {}" + e.getMessage(), e);
        }
    }
}
