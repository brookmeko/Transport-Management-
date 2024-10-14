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
public class DriverDTO {
    private UUID id;

    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String licenseId;
    private LocalDate dateOfBirth;

    private CompanyDTO company;
    private LocalDate employmentDate;
    private ZonedDateTime createdAt;




}