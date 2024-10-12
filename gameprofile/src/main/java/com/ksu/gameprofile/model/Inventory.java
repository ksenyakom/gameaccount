package com.ksu.gameprofile.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    @Column(name = "inventory_name", nullable = false, length = 50)
    private String inventoryName;

    @Column(name = "inventory_type", length = 50)
    private String inventoryType;

    @Column(name = "rarity", length = 50)
    private String rarity;
}
