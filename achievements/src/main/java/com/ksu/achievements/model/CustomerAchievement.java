package com.ksu.achievements.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "customer_achievement")
public class CustomerAchievement {

    @Id
    private String id;
    private String achievementId;
    private long customerId;
    private String timestamp;
}
