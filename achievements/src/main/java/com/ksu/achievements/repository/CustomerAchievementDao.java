package com.ksu.achievements.repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import com.ksu.achievements.model.CustomerAchievement;

@Component
public class CustomerAchievementDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Set<Long> getDistinctCustomers(){
        return new HashSet<>(mongoTemplate.findDistinct("customerId", CustomerAchievement.class, Long.class));
    }
}
