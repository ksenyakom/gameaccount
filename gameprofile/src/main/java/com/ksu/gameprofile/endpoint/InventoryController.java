package com.ksu.gameprofile.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ksu.gameprofile.model.Inventory;
import com.ksu.gameprofile.service.InventoryService;


@RestController
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping(path = "/{id}")
    public Inventory getInventory(@PathVariable("id") long inventoryId) {
        return inventoryService.find(inventoryId);
    }
}

