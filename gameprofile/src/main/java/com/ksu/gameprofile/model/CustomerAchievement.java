package com.ksu.gameprofile.model;

import org.springframework.data.annotation.Id;
import lombok.Data;


@Data
public class CustomerAchievement {


    private String id;

    private String achieventId;
    private long customerId;
    private String timestamp;
}
