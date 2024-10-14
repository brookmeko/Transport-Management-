package com.example.transportbackend.model.dto;
import com.example.transportbackend.model.entity.CompanyEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VehicleDTO {
    private UUID id;
    private String plateNumber;
    private boolean trailerTruck;
    private String carStatus;

    private UUID company;
    private String model;
    private LocalDate year;
    private ZonedDateTime createdAt;

    private LocalDate lastServiceDate;


}