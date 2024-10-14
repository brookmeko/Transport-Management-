package com.example.transportbackend.service;

import com.example.transportbackend.model.dto.FreightDTO;
import com.example.transportbackend.model.dto.VehicleDTO;

import java.util.List;
import java.util.UUID;

public interface VehicleService {



    List<VehicleDTO> getAllVehicle();

    VehicleDTO getVehicleById(UUID id);

    boolean createVehicle(VehicleDTO vehicleDTO);

    boolean updateVehicle(VehicleDTO vehicleDTO);

    boolean deleteVehicle(UUID id);
}
