package com.example.transportbackend.service;

import com.example.transportbackend.model.dto.DriverDTO;

import java.util.List;
import java.util.UUID;

public interface DriverService {
    List<DriverDTO> getAllDriver();

    DriverDTO getDriverById(UUID id);

    boolean createDriver(DriverDTO driverDTO);

    boolean updateDriver(DriverDTO driverDTO);

    boolean deleteDriver(UUID id);
}
