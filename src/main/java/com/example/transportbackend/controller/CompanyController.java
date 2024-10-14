package com.example.transportbackend.controller;

import com.example.transportbackend.model.dto.CompanyDTO;
import com.example.transportbackend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
public class CompanyController {

    @Autowired
    private CompanyService service;

    @GetMapping("/Company")
    public ResponseEntity<List<CompanyDTO>> getAllCompany(){
        try {
            List<CompanyDTO> resp = service.getAllCompany();
            return new ResponseEntity<>(resp, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/Company/{id}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable UUID id){
        CompanyDTO resp = service.getCompanyById(id);
        return ResponseEntity.ok().body(resp);

    }

    @PostMapping("/company")
    public ResponseEntity<String> createCompany(@RequestBody CompanyDTO CompanyDTO ){

        boolean withSuccess = service.createCompany(CompanyDTO);
        if (withSuccess){
            return ResponseEntity.ok().body("{\"message\":\"Success\"}");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error\"}");
        }
    }

    @PutMapping("/tran/Company/{id}")

    public ResponseEntity<String> updateCompany(@RequestBody CompanyDTO CompanyDTO){
        boolean withSuccess = service.updateCompany(CompanyDTO);
        if(withSuccess){
            return ResponseEntity.ok().body("{\"message\":\"Success\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error\"}");
        }

    }
    @DeleteMapping("/tras/Company/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable UUID id){
        boolean withSuccess = service.deleteCompany(id);
        if (withSuccess){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }
}
