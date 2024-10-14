package com.example.transportbackend.controller;

import com.example.transportbackend.model.dto.FreightDTO;
import com.example.transportbackend.service.FreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
public class FreightController {
    @Autowired
    private FreightService service;

    @GetMapping("/freight")
    public ResponseEntity<List<FreightDTO>> getAllFreight(){
        try {
            List<FreightDTO> resp = service.getAllFreight();
            return new ResponseEntity<>(resp, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/freight/{id}")
    public ResponseEntity<FreightDTO> getFreightById(@PathVariable UUID id){
        FreightDTO resp = service.getFreightById(id);
        return ResponseEntity.ok().body(resp);

    }

    @PostMapping("tras/freight")
    public ResponseEntity<String> createFreight(@RequestBody FreightDTO freightDTO ){

        boolean withSuccess = service.createFreight(freightDTO);
        if (withSuccess){
            return ResponseEntity.ok().body("{\"message\":\"Success\"}");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error\"}");
        }
    }

    @PutMapping("/tran/freight/{id}")

    public ResponseEntity<String> updateFreight(@RequestBody FreightDTO freightDTO){
        boolean withSuccess = service.updateFreight(freightDTO);
        if(withSuccess){
            return ResponseEntity.ok().body("{\"message\":\"Success\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error\"}");
        }

    }
    @DeleteMapping("/tras/freight/{id}")
    public ResponseEntity<String> deleteFreightById(@PathVariable UUID id){
        boolean withSuccess = service.deleteFreight(id);
        if (withSuccess){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }
}
