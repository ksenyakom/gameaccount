package com.ksu.gameprofile.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CustomerGameProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "game_level", nullable = false)
    private int gameLevel;

    @Column(name = "experience", nullable = false)
    private int experience;

    @Column(name = "game_currency_balance", nullable = false)
    private int gameCurrencyBalance;

}
