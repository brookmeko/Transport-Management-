package com.example.transportbackend.service;

import com.example.transportbackend.model.dto.FreightDTO;

import java.util.List;
import java.util.UUID;

public interface FreightService {
    List<FreightDTO> getAllFreight();

    FreightDTO getFreightById(UUID id);

    boolean createFreight(FreightDTO freightDTO);

    boolean updateFreight(FreightDTO freightDTO);

    boolean deleteFreight(UUID id);
}
