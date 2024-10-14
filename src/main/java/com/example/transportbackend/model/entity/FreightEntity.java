package com.example.transportbackend.model.entity;
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
@Entity
@Table(name = "freights")
public class FreightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String freightType;
    private Integer weight;
    private BigDecimal tariff;
    private String description;
    private LocalDate customsInDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "operations", nullable = false)
    private OperationEntity operation;
}