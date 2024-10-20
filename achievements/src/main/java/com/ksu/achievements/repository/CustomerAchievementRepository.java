package com.ksu.achievements.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.ksu.achievements.model.CustomerAchievement;

@Repository
public interface CustomerAchievementRepository extends MongoRepository<CustomerAchievement, String> {
    List<CustomerAchievement> findAllByCustomerId(long customerId);
}
