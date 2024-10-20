package com.ksu.payments.model;


import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("payment")
public class Payment {

    @Id
    private long transactionId;

    @Column
    private long customerId;

    @Column
    private String createdAt;

    @Column
    private BigDecimal amount;

    @Column
    private String currency;

    @Column
    private String status;
}
