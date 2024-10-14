package com.example.transportbackend.model.dto;

import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class AddressDTO {
    private UUID id;
    private String street;
    private String city;
    private String state;
    private String zone;
    private String woreda;
    private ZonedDateTime createdAt;



}
