package com.example.transportbackend.service;

import com.example.transportbackend.model.dto.VehicleAssignedDTO;

import java.util.List;
import java.util.UUID;

public interface VehicleAssignedService {



    List<VehicleAssignedDTO> getAllVehicleAssigned();

    VehicleAssignedDTO getVehicleAssignedById(UUID id);

    boolean createVehicleAssigned(VehicleAssignedDTO VehicleAssignedDTO);

    boolean updateVehicleAssigned(VehicleAssignedDTO VehicleAssignedDTO);

    boolean deleteVehicleAssigned(UUID id);
}
