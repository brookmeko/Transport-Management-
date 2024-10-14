package com.example.transportbackend.controller;

import com.example.transportbackend.model.dto.VehicleDTO;
import com.example.transportbackend.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
public class VehicleController {
    @Autowired
    private VehicleService service;

    @GetMapping("/vehicle")
    public ResponseEntity<List<VehicleDTO>> getAllVehicle(){
        try {
            List<VehicleDTO> resp = service.getAllVehicle();
            return new ResponseEntity<>(resp, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/vehicle/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable UUID id){
        VehicleDTO resp = service.getVehicleById(id);
        return ResponseEntity.ok().body(resp);

    }

    @PostMapping("/trans/vehicle")
    public ResponseEntity<String> createVehicle(@RequestBody VehicleDTO vehicleDTO ){

        boolean withSuccess = service.createVehicle(vehicleDTO);
        if (withSuccess){
            return ResponseEntity.ok().body("{\"message\":\"Success\"}");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error\"}");
        }
    }

    @PutMapping("/tran/vehicle/{id}")

    public ResponseEntity<String> updateVehicle(@RequestBody VehicleDTO vehicleDTO){
        boolean withSuccess = service.updateVehicle(vehicleDTO);
        if(withSuccess){
            return ResponseEntity.ok().body("{\"message\":\"Success\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error\"}");
        }

    }
    @DeleteMapping("/tras/vehicle/{id}")
    public ResponseEntity<String> deleteVehicleById(@PathVariable UUID id){
        boolean withSuccess = service.deleteVehicle(id);
        if (withSuccess){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }
}
