package com.example.transportbackend.model.dto;


import com.example.transportbackend.model.entity.AddressEntity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {

    private UUID id;

    private String name;

    private UUID addressId;
    private Integer phoneNumber;
    private String email;
    private ZonedDateTime createdAt;




}
