package com.example.transportbackend.service;

import com.example.transportbackend.model.dto.AddressDTO;

import java.util.List;
import java.util.UUID;

public interface AddressService {

    List<AddressDTO> getAllAddress();

    AddressDTO getAddressById(UUID id);

    boolean createAddress(AddressDTO addressDTO);
    boolean updateAddress(AddressDTO addressDTO);

    boolean deleteAddress(UUID id);
}
