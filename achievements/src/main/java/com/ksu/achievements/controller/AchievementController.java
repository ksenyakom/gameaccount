package com.ksu.achievements.controller;


import java.awt.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ksu.achievements.model.Achievement;
import com.ksu.achievements.service.AchievementService;

@RestController
@RequestMapping("/achievements")
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    @GetMapping
    public List<Achievement> getList() {
        return achievementService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Achievement save(@RequestBody Achievement achievement) {
        return achievementService.save(achievement);
    }
}
