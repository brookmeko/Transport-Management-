package com.example.transportbackend.controller;

import com.example.transportbackend.model.dto.CustomerDTO;
import com.example.transportbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController

public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("/Customer")
    public ResponseEntity<List<CustomerDTO>> getAllCustomer(){
        try {
            List<CustomerDTO> resp = service.getAllCustomer();
            return new ResponseEntity<>(resp, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/Customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable UUID id){
        CustomerDTO resp = service.getCustomerById(id);
        return ResponseEntity.ok().body(resp);

    }

    @PostMapping("/tran/Customer")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerDTO CustomerDTO ){

        boolean withSuccess = service.createCustomer(CustomerDTO);
        if (withSuccess){
            return ResponseEntity.ok().body("{\"message\":\"Success\"}");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error\"}");
        }
    }

    @PutMapping("/tran/Customer/{id}")

    public ResponseEntity<String> updateCustomer(@RequestBody CustomerDTO CustomerDTO){
        boolean withSuccess = service.updateCustomer(CustomerDTO);
        if(withSuccess){
            return ResponseEntity.ok().body("{\"message\":\"Success\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error\"}");
        }

    }
    @DeleteMapping("/tras/Customer/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable UUID id){
        boolean withSuccess = service.deleteCustomer(id);
        if (withSuccess){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }
}
