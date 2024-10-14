package com.example.transportbackend.service;

import com.example.transportbackend.exception.ResourceNotFoundException;
import com.example.transportbackend.model.dto.TripeDTO;
import com.example.transportbackend.model.dto.TripeDTO;
import com.example.transportbackend.model.entity.TripeEntity;
import com.example.transportbackend.model.repository.TripeJpaRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TripeServiceImpl implements TripeService{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TripeJpaRepo repository;

    @Override
    public List<TripeDTO> getAllTripe() {

        List<TripeDTO> TripeDTO = repository.findAll().stream()
                .map(Tripe -> modelMapper.map(Tripe, TripeDTO.class)).collect(Collectors.toList());
        return TripeDTO;
    }

    @Override
    public TripeDTO getTripeById(UUID id) {
        try{
            Optional<TripeEntity> Tripe = repository.findById(id);
            TripeDTO TripeDTO = modelMapper.map(Tripe, TripeDTO.class);

            return TripeDTO;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public boolean createTripe(TripeDTO TripeDTO) {
        try{
            TripeEntity Tripe = modelMapper.map(TripeDTO, TripeEntity.class);
            repository.save(Tripe);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateTripe(TripeDTO TripeDTO) {
        try {
            TripeEntity Tripe = modelMapper.map(TripeDTO, TripeEntity.class);
            repository.save(Tripe);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean deleteTripe(UUID id) {
        try{
            TripeEntity Tripe = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Tripe not found::" + id));
            repository.delete(Tripe);
            return true;
        }catch (ResourceNotFoundException e){
            e.printStackTrace();
            return false;
        }

    }
}
