package com.ksu.achievements.job;


import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.ksu.achievements.model.CustomerAchievement;
import com.ksu.achievements.model.Statistics;
import com.ksu.achievements.service.CustomerAchievementService;
import com.ksu.achievements.service.StatisticsService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CountStatisticsJob {

    private static final int THREAD_POOL_SIZE = 4;

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private CustomerAchievementService customerAchievementService;

    @Scheduled(fixedRate = 10000 )
    public void execute() {
        log.info(CountStatisticsJob.class.getName() + " started");

        Set<Long> customers;
        try {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
            customers = statisticsService.getAllCustomers();
            for (Long customerId : customers) {
                executorService.submit(() -> this.countStatistics(customerId));
            }

            executorService.shutdown();
            while (!executorService.isTerminated()) {
                // Wait for all tasks to finish
            }
            log.info(CountStatisticsJob.class.getName() + " finished, processed " + customers.size() + " customers");
        } catch (Exception e) {
            log.error("Error counting statistics: ", e);
        }
    }

    private void countStatistics(Long customerId) {
        try {
            List<CustomerAchievement> achievements = customerAchievementService.findAllByCustomerId(customerId);
            Map<String, Integer> statMap = achievements.stream()
                    .collect(Collectors.toMap(CustomerAchievement::getAchievementId, ca -> 1, (a, b) -> a + 1));

            List<Statistics> statistics = statMap.entrySet().stream().map(entrySet -> Statistics.builder()
                            .customerId(customerId)
                            .statName(entrySet.getKey())
                            .count(entrySet.getValue())
                            .timestamp(ZonedDateTime.now(ZoneOffset.UTC).toString())
                            .build())
                    .toList();
            statisticsService.saveAll(statistics, customerId);
        } catch (Exception e) {
            log.error("Error counting statistics: ", e);
        }
    }
}
