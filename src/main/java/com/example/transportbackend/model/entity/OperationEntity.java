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
@Table(name = "operations")
public class OperationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String startingOrigin;
    private String destination;
    private String distance;
    private BigDecimal initialAmount;
    private BigDecimal payment;
    private BigDecimal paidAmount;
    private BigDecimal returnAmount;
    private BigDecimal remaining;
    private BigDecimal totalPayment;
    private ZonedDateTime customsInDate;
    private ZonedDateTime customsOutDate;
    private ZonedDateTime unloadingDate;
    private ZonedDateTime upLoadingDate;
    private ZonedDateTime borderCrossingDate;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicles_assigned", nullable = false)
    private VehicleAssignedEntity vehicleAssigned;
    private ZonedDateTime createdAt;

}