package com.example.transportbackend.model.dto;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TripeDTO {
    private UUID id;

    private String startingOrigin;
    private String destination;
}
