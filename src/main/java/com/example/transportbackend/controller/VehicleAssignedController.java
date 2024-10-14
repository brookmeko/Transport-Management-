package com.example.transportbackend.controller;

import com.example.transportbackend.model.dto.VehicleAssignedDTO;
import com.example.transportbackend.service.VehicleAssignedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
public class VehicleAssignedController {
    @Autowired
    private VehicleAssignedService service;

    @GetMapping("/vehicleAssigned")
    public ResponseEntity<List<VehicleAssignedDTO>> getAllVehicleAssigned(){
        try {
            List<VehicleAssignedDTO> resp = service.getAllVehicleAssigned();
            return new ResponseEntity<>(resp, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/vehicleAssigned/{id}")
    public ResponseEntity<VehicleAssignedDTO> getVehicleAssignedById(@PathVariable UUID id){
        VehicleAssignedDTO resp = service.getVehicleAssignedById(id);
        return ResponseEntity.ok().body(resp);

    }

    @PostMapping("tras/vehicleAssigned")
    public ResponseEntity<String> createVehicleAssigned(@RequestBody VehicleAssignedDTO vehicleAssignedDTO ){

        boolean withSuccess = service.createVehicleAssigned(vehicleAssignedDTO);
        if (withSuccess){
            return ResponseEntity.ok().body("{\"message\":\"Success\"}");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error\"}");
        }
    }

    @PutMapping("/tran/vehicleAssigned/{id}")

    public ResponseEntity<String> updateVehicleAssigned(@RequestBody VehicleAssignedDTO vehicleAssignedDTO){
        boolean withSuccess = service.updateVehicleAssigned(vehicleAssignedDTO);
        if(withSuccess){
            return ResponseEntity.ok().body("{\"message\":\"Success\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error\"}");
        }

    }
    @DeleteMapping("/tras/vehicleAssigned/{id}")
    public ResponseEntity<String> deleteVehicleAssignedById(@PathVariable UUID id){
        boolean withSuccess = service.deleteVehicleAssigned(id);
        if (withSuccess){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }
}
