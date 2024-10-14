package com.example.transportbackend.model.dto;

import com.example.transportbackend.model.entity.AddressEntity;
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
public class CustomerDTO {
    private UUID id;

    private String name;
    private String phoneNumber;

    private AddressDTO address;

    private OperationDTO operation;

    private String email;
    private String remark;
    private String contactPerson;
    private ZonedDateTime createdAt;



}