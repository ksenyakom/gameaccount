package com.ksu.achievements.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ksu.achievements.kafka.KafkaMessageProducer;
import com.ksu.achievements.model.CustomerAchievement;
import com.ksu.achievements.repository.CustomerAchievementRepository;

@Service
public class CustomerAchievementService {

    @Autowired
    private CustomerAchievementRepository customerAchievementRepository;

    @Autowired
    private KafkaMessageProducer kafkaMessageProducer;

    public List<CustomerAchievement> findAll() {
        return customerAchievementRepository.findAll();
    }

    public CustomerAchievement save(CustomerAchievement achievement) {
        achievement.setTimestamp(LocalDateTime.now().toString());
        CustomerAchievement saved = customerAchievementRepository.save(achievement);

        kafkaMessageProducer.sendRequestMessage(saved);

        return saved;
    }
}
