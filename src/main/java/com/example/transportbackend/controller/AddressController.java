package com.example.transportbackend.controller;

import com.example.transportbackend.model.dto.AddressDTO;
import com.example.transportbackend.service.AddressService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping ("/address")
    public ResponseEntity<List<AddressDTO>> getAllAddress(){
        try {
            List<AddressDTO> resp = service.getAllAddress();
            return new ResponseEntity<>(resp, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable UUID id){
        AddressDTO resp = service.getAddressById(id);
        return ResponseEntity.ok().body(resp);

    }

    @PostMapping("/address")
    public ResponseEntity<String> createAddress(@RequestBody AddressDTO addressDTO ){

        boolean withSuccess = service.createAddress(addressDTO);
        if (withSuccess){
            return ResponseEntity.ok().body("{\"message\":\"Success\"}");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error\"}");
        }
    }

    @PutMapping("/tran/address/{id}")

    public ResponseEntity<String> updateAddress(@RequestBody AddressDTO addressDTO){
        boolean withSuccess = service.updateAddress(addressDTO);
        if(withSuccess){
            return ResponseEntity.ok().body("{\"message\":\"Success\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error\"}");
        }

    }
    @DeleteMapping("/tras/address/{id}")
    public ResponseEntity<String> deleteAddressById(@PathVariable UUID id){
        boolean withSuccess = service.deleteAddress(id);
        if (withSuccess){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }
}
