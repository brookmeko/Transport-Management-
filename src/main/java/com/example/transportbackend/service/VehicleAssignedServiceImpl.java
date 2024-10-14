package com.example.transportbackend.service;

import com.example.transportbackend.exception.ResourceNotFoundException;
import com.example.transportbackend.model.dto.VehicleAssignedDTO;
import com.example.transportbackend.model.entity.VehicleAssignedEntity;
import com.example.transportbackend.model.repository.VehicleAssignedJpaRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service

public class VehicleAssignedServiceImpl implements VehicleAssignedService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VehicleAssignedJpaRepo repository;

    @Override
    public List<VehicleAssignedDTO> getAllVehicleAssigned() {

        List<VehicleAssignedDTO> VehicleAssignedDTO = repository.findAll().stream()
                .map(VehicleAssigned -> modelMapper.map(VehicleAssigned, VehicleAssignedDTO.class)).collect(Collectors.toList());
        return VehicleAssignedDTO;
    }

    @Override
    public VehicleAssignedDTO getVehicleAssignedById(UUID id) {
        try{
            Optional<VehicleAssignedEntity> VehicleAssigned = repository.findById(id);
            VehicleAssignedDTO VehicleAssignedDTO = modelMapper.map(VehicleAssigned, VehicleAssignedDTO.class);

            return VehicleAssignedDTO;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public boolean createVehicleAssigned(VehicleAssignedDTO VehicleAssignedDTO) {
        try{
            VehicleAssignedEntity VehicleAssigned = modelMapper.map(VehicleAssignedDTO, VehicleAssignedEntity.class);
            repository.save(VehicleAssigned);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateVehicleAssigned(VehicleAssignedDTO VehicleAssignedDTO) {
        try {
            VehicleAssignedEntity VehicleAssigned = modelMapper.map(VehicleAssignedDTO, VehicleAssignedEntity.class);
            repository.save(VehicleAssigned);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean deleteVehicleAssigned(UUID id) {
        try{
            VehicleAssignedEntity VehicleAssigned = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("VehicleAssigned not found::" + id));
            repository.delete(VehicleAssigned);
            return true;
        }catch (ResourceNotFoundException e){
            e.printStackTrace();
            return false;
        }

    }
}
