package com.ksu.achievements.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ksu.achievements.model.Achievement;

public interface AchievementRepository extends MongoRepository<Achievement, String> {
}
