package com.example.transportbackend.service;

import com.example.transportbackend.exception.ResourceNotFoundException;
import com.example.transportbackend.model.dto.CustomerDTO;

import com.example.transportbackend.model.entity.CustomerEntity;
import com.example.transportbackend.model.repository.CustomerJpaRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerJpaRepo repository;
    
    @Override
    public List<CustomerDTO> getAllCustomer() {

        List<CustomerDTO> customerDTO = repository.findAll().stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class)).collect(Collectors.toList());
        return customerDTO;
    }

    @Override
    public CustomerDTO getCustomerById(UUID id) {
        try{
            Optional<CustomerEntity> customer = repository.findById(id);
            CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);

            return customerDTO;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }   
    }
    @Override
    public boolean createCustomer(CustomerDTO customerDTO) {
        try{
            CustomerEntity customer = modelMapper.map(customerDTO, CustomerEntity.class);
            CustomerDTO customerObject = new CustomerDTO();
            customerObject.setAddress(customerDTO.getAddress());
            repository.save(customer);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {
        try {
            CustomerEntity customer = modelMapper.map(customerDTO, CustomerEntity.class);
            CustomerDTO customerObject = new CustomerDTO();
            customerObject.setAddress(customerDTO.getAddress());
            repository.save(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean deleteCustomer(UUID id) {
        try{
            CustomerEntity customer = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("addres not found::" + id));
            repository.delete(customer);
            return true;
        }catch (ResourceNotFoundException e){
            e.printStackTrace();
            return false;
        }

    }
}
