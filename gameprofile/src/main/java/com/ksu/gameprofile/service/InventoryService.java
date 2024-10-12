package com.ksu.gameprofile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ksu.gameprofile.model.Inventory;
import com.ksu.gameprofile.repository.InventoryRepository;
import com.ksu.gameprofile.service.exception.EntityNotFoundException;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory find(long inventoryId) {
        return inventoryRepository.findById(inventoryId)
                .orElseThrow(EntityNotFoundException::new);

    }
}
