package com.example.transportbackend.service;

import com.example.transportbackend.exception.ResourceNotFoundException;
import com.example.transportbackend.model.dto.CompanyDTO;
import com.example.transportbackend.model.dto.CustomerDTO;
import com.example.transportbackend.model.dto.VehicleDTO;
import com.example.transportbackend.model.entity.CompanyEntity;
import com.example.transportbackend.model.entity.VehicleEntity;
import com.example.transportbackend.model.repository.CompanyJpaRepo;
import com.example.transportbackend.model.repository.VehicleJpaRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService{


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CompanyJpaRepo companyJpaRepo;

    @Autowired
    private VehicleJpaRepo repository;

    @Override
    public List<VehicleDTO> getAllVehicle() {

        List<VehicleDTO> vehicleDTO = repository.findAll().stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleDTO.class)).collect(Collectors.toList());
        return vehicleDTO;
    }

    @Override
    public VehicleDTO getVehicleById(UUID id) {
        try{
            Optional<VehicleEntity> vehicle = repository.findById(id);
            VehicleDTO vehicleDTO = modelMapper.map(vehicle, VehicleDTO.class);

            return vehicleDTO;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public boolean createVehicle(VehicleDTO vehicleDTO) {
        try{
            VehicleEntity vehicle = modelMapper.map(vehicleDTO, VehicleEntity.class);
            VehicleDTO vehicleObject = new VehicleDTO();
            vehicleObject.setCompany(vehicleDTO.getCompany());

            repository.save(vehicle);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateVehicle(VehicleDTO vehicleDTO) {
        try {
            VehicleEntity vehicle = modelMapper.map(vehicleDTO, VehicleEntity.class);
            repository.save(vehicle);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean deleteVehicle(UUID id) {
        try{
            VehicleEntity vehicle = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("addres not found::" + id));
            repository.delete(vehicle);
            return true;
        }catch (ResourceNotFoundException e){
            e.printStackTrace();
            return false;
        }

    }
}
