package com.ksu.gameprofile.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.ksu.gameprofile.model.CustomerInventory;

public interface CustomerInventoryRepository extends CrudRepository<CustomerInventory, Long> {
    List<CustomerInventory> findByCustomerId(long customerId);
}
