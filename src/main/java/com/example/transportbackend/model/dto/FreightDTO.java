package com.example.transportbackend.model.dto;

import com.example.transportbackend.model.entity.OperationEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FreightDTO {
    private UUID id;

    private String freightType;
    private Integer weight;
    private BigDecimal tariff;
    private String description;
    private LocalDate customsInDate;
    private LocalDate borderCrossingDate;

    private OperationEntity operation;
}