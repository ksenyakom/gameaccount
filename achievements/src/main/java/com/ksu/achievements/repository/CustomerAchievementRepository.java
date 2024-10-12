package com.ksu.achievements.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.ksu.achievements.model.Achievement;
import com.ksu.achievements.model.CustomerAchievement;

@Repository
public interface CustomerAchievementRepository extends MongoRepository<CustomerAchievement, String> {
}
