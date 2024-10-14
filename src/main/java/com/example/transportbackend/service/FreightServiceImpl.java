package com.example.transportbackend.service;

import com.example.transportbackend.exception.ResourceNotFoundException;
import com.example.transportbackend.model.dto.FreightDTO;
import com.example.transportbackend.model.entity.FreightEntity;
import com.example.transportbackend.model.repository.FreightJpaRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FreightServiceImpl implements FreightService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FreightJpaRepo repository;

    @Override
    public List<FreightDTO> getAllFreight() {

        List<FreightDTO> freightDTO = repository.findAll().stream()
                .map(freight -> modelMapper.map(freight, FreightDTO.class)).collect(Collectors.toList());
        return freightDTO;
    }

    @Override
    public FreightDTO getFreightById(UUID id) {
        try{
            Optional<FreightEntity> freight = repository.findById(id);
            FreightDTO freightDTO = modelMapper.map(freight, FreightDTO.class);

            return freightDTO;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public boolean createFreight(FreightDTO freightDTO) {
        try{
            FreightEntity freight = modelMapper.map(freightDTO, FreightEntity.class);
            repository.save(freight);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateFreight(FreightDTO freightDTO) {
        try {
            FreightEntity freight = modelMapper.map(freightDTO, FreightEntity.class);
            repository.save(freight);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean deleteFreight(UUID id) {
        try{
            FreightEntity freight = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("addres not found::" + id));
            repository.delete(freight);
            return true;
        }catch (ResourceNotFoundException e){
            e.printStackTrace();
            return false;
        }

    }
}
