package com.ksu.achievements.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document
@Data
public class CustomerAchievement {

    @Id
    private String id;
    private String achieventId;
    private long customerId;
    private String timestamp;
}
