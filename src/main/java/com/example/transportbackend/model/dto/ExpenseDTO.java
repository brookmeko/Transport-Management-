package com.example.transportbackend.model.dto;

import com.example.transportbackend.model.entity.CustomerEntity;
import com.example.transportbackend.model.entity.OperationEntity;
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

public class ExpenseDTO {
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
    private OperationDTO operation;
    private ZonedDateTime createdAt;




}