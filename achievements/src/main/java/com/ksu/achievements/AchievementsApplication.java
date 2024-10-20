package com.ksu.achievements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableMongoRepositories(basePackages = "com.ksu.achievements.repository")
public class AchievementsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AchievementsApplication.class, args);
    }

}
