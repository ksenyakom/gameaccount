package com.ksu.achievements.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ksu.achievements.model.Statistics;
import com.ksu.achievements.repository.StatisticsRepository;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    public void saveAll(List<Statistics> statistics, long customerId) {
        Map<String, Statistics> existingStat = statisticsRepository.findByCustomerId(customerId)
                .stream()
                .collect(Collectors.toMap(Statistics::getStatName, s -> s));

        for (Statistics stat : statistics) {
            if (existingStat.containsKey(stat.getStatName())) {
                stat.setId(existingStat.get(stat.getStatName()).getId());
            }
        }
        statisticsRepository.saveAll(statistics);
    }
}
