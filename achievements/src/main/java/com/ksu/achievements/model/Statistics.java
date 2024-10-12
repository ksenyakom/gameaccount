package com.ksu.achievements.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Statistics")
public class Statistics {

    @Id
    private String id;

    private String statName;
    private long customerId;
    private String timestamp;
}
