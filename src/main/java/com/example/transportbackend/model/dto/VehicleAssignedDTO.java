package com.example.transportbackend.model.dto;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleAssignedDTO {

    private UUID id;

    private VehicleDTO vehicle;

    private DriverDTO driver;
}
