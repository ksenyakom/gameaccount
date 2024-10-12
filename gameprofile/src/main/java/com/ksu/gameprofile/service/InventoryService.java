package com.ksu.gameprofile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ksu.gameprofile.cache.InventoryCache;
import com.ksu.gameprofile.model.Inventory;
import com.ksu.gameprofile.repository.InventoryRepository;
import com.ksu.gameprofile.service.exception.EntityNotFoundException;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryCache inventoryCache;

    public Inventory find(Long inventoryId) {
        Inventory inventory = inventoryCache.getValue(new InventoryCache.InventoryCacheKey(inventoryId));

        if (inventory == null) {
            throw new EntityNotFoundException("Inventory not found");
        }
        return inventory;
    }
}
