package com.example.transportbackend.controller;

import com.example.transportbackend.model.dto.TripeDTO;
import com.example.transportbackend.service.TripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
public class TripeController {
    @Autowired
    private TripeService service;

    @GetMapping("/tripe")
    public ResponseEntity<List<TripeDTO>> getAllTripe(){
        try {
            List<TripeDTO> resp = service.getAllTripe();
            return new ResponseEntity<>(resp, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/tripe/{id}")
    public ResponseEntity<TripeDTO> getTripeById(@PathVariable UUID id){
        TripeDTO resp = service.getTripeById(id);
        return ResponseEntity.ok().body(resp);

    }

    @PostMapping("tras/tripe")
    public ResponseEntity<String> createTripe(@RequestBody TripeDTO tripeDTO ){

        boolean withSuccess = service.createTripe(tripeDTO);
        if (withSuccess){
            return ResponseEntity.ok().body("{\"message\":\"Success\"}");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error\"}");
        }
    }

    @PutMapping("/tran/tripe/{id}")

    public ResponseEntity<String> updateTripe(@RequestBody TripeDTO tripeDTO){
        boolean withSuccess = service.updateTripe(tripeDTO);
        if(withSuccess){
            return ResponseEntity.ok().body("{\"message\":\"Success\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error\"}");
        }

    }
    @DeleteMapping("/tras/tripe/{id}")
    public ResponseEntity<String> deleteTripeById(@PathVariable UUID id){
        boolean withSuccess = service.deleteTripe(id);
        if (withSuccess){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }
}
