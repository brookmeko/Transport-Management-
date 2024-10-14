package com.example.transportbackend.controller;

import com.example.transportbackend.model.dto.ExpenseDTO;
import com.example.transportbackend.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
public class ExpenseController {
    @Autowired
    private ExpenseService service;

    @GetMapping("/expense")
    public ResponseEntity<List<ExpenseDTO>> getAllExpense(){
        try {
            List<ExpenseDTO> resp = service.getAllExpense();
            return new ResponseEntity<>(resp, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/expense/{id}")
    public ResponseEntity<ExpenseDTO> getExpenseById(@PathVariable UUID id){
        ExpenseDTO resp = service.getExpenseById(id);
        return ResponseEntity.ok().body(resp);

    }

    @PostMapping("tras/expense")
    public ResponseEntity<String> createExpense(@RequestBody ExpenseDTO expenseDTO ){

        boolean withSuccess = service.createExpense(expenseDTO);
        if (withSuccess){
            return ResponseEntity.ok().body("{\"message\":\"Success\"}");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error\"}");
        }
    }

    @PutMapping("/tran/expense/{id}")

    public ResponseEntity<String> updateExpense(@RequestBody ExpenseDTO expenseDTO){
        boolean withSuccess = service.updateExpense(expenseDTO);
        if(withSuccess){
            return ResponseEntity.ok().body("{\"message\":\"Success\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Error\"}");
        }

    }
    @DeleteMapping("/tras/expense/{id}")
    public ResponseEntity<String> deleteExpenseById(@PathVariable UUID id){
        boolean withSuccess = service.deleteExpense(id);
        if (withSuccess){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }
}
