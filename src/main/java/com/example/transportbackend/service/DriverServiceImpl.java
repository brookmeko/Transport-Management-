package com.example.transportbackend.service;

import com.example.transportbackend.exception.ResourceNotFoundException;
import com.example.transportbackend.model.dto.DriverDTO;
import com.example.transportbackend.model.entity.DriverEntity;
import com.example.transportbackend.model.repository.DriverJpaRepo;
import com.example.transportbackend.model.repository.DriverJpaRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService{


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DriverJpaRepo repository;

    @Override
    public List<DriverDTO> getAllDriver() {

        List<DriverDTO> driverDTO = repository.findAll().stream()
                .map(driver -> modelMapper.map(driver, DriverDTO.class)).collect(Collectors.toList());
        return driverDTO;
    }

    @Override
    public DriverDTO getDriverById(UUID id) {
        try{
            Optional<DriverEntity> driver = repository.findById(id);
            DriverDTO driverDTO = modelMapper.map(driver, DriverDTO.class);

            return driverDTO;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public boolean createDriver(DriverDTO driverDTO) {
        try{
            DriverEntity driver = modelMapper.map(driverDTO, DriverEntity.class);
            repository.save(driver);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateDriver(DriverDTO driverDTO) {
        try {
            DriverEntity driver = modelMapper.map(driverDTO, DriverEntity.class);
            repository.save(driver);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean deleteDriver(UUID id) {
        try{
            DriverEntity driver = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("addres not found::" + id));
            repository.delete(driver);
            return true;
        }catch (ResourceNotFoundException e){
            e.printStackTrace();
            return false;
        }

    }
}
