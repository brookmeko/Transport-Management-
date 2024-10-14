package com.example.transportbackend.controller;

import com.example.transportbackend.model.dto.DriverDTO;
import com.example.transportbackend.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
public class DriverController {

    @Autowired
    private DriverService service;

    @GetMapping("/driver")
    public ResponseEntity<List<DriverDTO>> getAllDriver(){
        try {
            List<DriverDTO> resp = service.getAllDriver();
            return new ResponseEntity<>(resp, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/driver/{id}")
    public ResponseEntity<DriverDTO> getDriverById(@PathVariable UUID id){
        DriverDTO resp = service.getDriverById(id);
        return ResponseEntity.ok().body(resp);

    }

    @PostMapping("tras/driver")
    public ResponseEntity<String> createDriver(@RequestBody DriverDTO driverDTO ){

        boolean withSuccess = service.createDriver(driverDTO);
        if (withSuccess){
            return ResponseEntity.ok().body("{\"message\":\"Success\"}");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error\"}");
        }
    }

    @PutMapping("/tran/driver/{id}")

    public ResponseEntity<String> updateDriver(@RequestBody DriverDTO driverDTO){
        boolean withSuccess = service.updateDriver(driverDTO);
        if(withSuccess){
            return ResponseEntity.ok().body("{\"message\":\"Success\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error\"}");
        }

    }
    @DeleteMapping("/tras/driver/{id}")
    public ResponseEntity<String> deleteDriverById(@PathVariable UUID id){
        boolean withSuccess = service.deleteDriver(id);
        if (withSuccess){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }
}
