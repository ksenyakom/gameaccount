package com.ksu.achievements.repository;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.ksu.achievements.model.Statistics;

@Repository
public interface StatisticsRepository extends MongoRepository<Statistics,Long> {

    Set<Statistics> findByCustomerId(long customerId);
}
