package com.ksu.achievements.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ksu.achievements.kafka.KafkaMessageProducer;
import com.ksu.achievements.model.Achievement;
import com.ksu.achievements.repository.AchievementRepository;

@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;


    public List<Achievement> findAll() {
        return achievementRepository.findAll();
    }

    public Achievement save(Achievement achievement) {
        Achievement savedAchievement = achievementRepository.save(achievement);
        return savedAchievement;
    }
}
