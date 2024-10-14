package com.example.transportbackend.service;

import com.example.transportbackend.exception.ResourceNotFoundException;
import com.example.transportbackend.model.dto.AddressDTO;
import com.example.transportbackend.model.entity.AddressEntity;
import com.example.transportbackend.model.repository.AddressJpaRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private AddressJpaRepo repository;


    @Override
    public List<AddressDTO> getAllAddress() {

        List<AddressDTO> addressDTO = repository.findAll().stream()
                .map(address -> modelMapper.map(address, AddressDTO.class)).collect(Collectors.toList());
        return addressDTO;
    }

    @Override
    public AddressDTO getAddressById(UUID id) {
        try{
            Optional<AddressEntity> address = repository.findById(id);
            AddressDTO addressDTO = modelMapper.map(address, AddressDTO.class);

            return addressDTO;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean createAddress(AddressDTO addressDTO) {
        try{
            AddressEntity address = modelMapper.map(addressDTO, AddressEntity.class);
            repository.save(address);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateAddress(AddressDTO addressDTO) {
        try {
            AddressEntity address = modelMapper.map(addressDTO, AddressEntity.class);
            repository.save(address);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean deleteAddress(UUID id) {
        try{
            AddressEntity address = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("addres not found::" + id));
            repository.delete(address);
            return true;
        }catch (ResourceNotFoundException e){
            e.printStackTrace();
            return false;
        }

    }
}
