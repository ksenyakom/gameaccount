package com.ksu.gameprofile.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CustomerInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long inventoryId;

    @Column(nullable = false)
    private long customerId;

    @Column(nullable = false)
    private int inventoryCount;

    @Column
    private boolean consumable;
}
