package com.ksu.achievements.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "statistics")
public class Statistics {

    @Id
    private String id;

    private String statName;
    private long customerId;
    private long count;
    private String timestamp;
}
