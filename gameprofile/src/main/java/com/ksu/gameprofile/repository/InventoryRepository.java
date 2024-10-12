package com.ksu.gameprofile.repository;

import org.springframework.data.repository.CrudRepository;
import com.ksu.gameprofile.model.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {
    Inventory findByInventoryId(long inventoryId);
}
