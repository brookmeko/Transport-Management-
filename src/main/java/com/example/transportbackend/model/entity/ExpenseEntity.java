package com.example.transportbackend.model.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "expenses")
public class ExpenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private BigDecimal fuel;
    private BigDecimal miscellaneous;
    private BigDecimal allowance;
    private BigDecimal driverRefund;

    private BigDecimal income;
    private BigDecimal companyRefund;
    private BigDecimal netIncome;
    private BigDecimal demurrage;
    private String remark;
    private BigDecimal totalAmount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "operation_id", nullable = false)
    private OperationEntity operation;
    private ZonedDateTime createdAt;


}