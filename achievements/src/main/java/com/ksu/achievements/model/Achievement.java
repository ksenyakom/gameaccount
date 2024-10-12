package com.ksu.achievements.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Achievement")
public class Achievement {

    @Id
    private String id;

    private String achievementId;
    private String achievementName;
    private String timestamp;
    private String reward;
}
