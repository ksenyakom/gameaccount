package com.ksu.gameprofile.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.ksu.gameprofile.model.CustomerInventory;

public interface CustomerInventoryRepository extends CrudRepository<CustomerInventory, Long> {
    Optional<CustomerInventory> findByCustomerId(long customerId);
}
