package com.ksu.achievements.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ksu.achievements.model.Achievement;
import com.ksu.achievements.model.CustomerAchievement;
import com.ksu.achievements.service.AchievementService;
import com.ksu.achievements.service.CustomerAchievementService;

@RestController
@RequestMapping("/customer/achievements")
public class CustomerAchievementController {

    @Autowired
    private CustomerAchievementService customerAchievementService;

    @GetMapping
    public List<CustomerAchievement> getList() {
        return customerAchievementService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerAchievement save(@RequestBody CustomerAchievement customerAchievement) {
        return customerAchievementService.save(customerAchievement);
    }
}