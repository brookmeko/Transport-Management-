package com.example.transportbackend.service;

import com.example.transportbackend.model.dto.CustomerDTO;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<CustomerDTO> getAllCustomer();

    CustomerDTO getCustomerById(UUID id);

    boolean createCustomer(CustomerDTO customerDTO);

    boolean updateCustomer(CustomerDTO customerDTO);

    boolean deleteCustomer(UUID id);
}
