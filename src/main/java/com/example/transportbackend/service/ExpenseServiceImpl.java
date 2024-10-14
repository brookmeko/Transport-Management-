package com.example.transportbackend.service;

import com.example.transportbackend.exception.ResourceNotFoundException;
import com.example.transportbackend.model.dto.ExpenseDTO;
import com.example.transportbackend.model.entity.ExpenseEntity;
import com.example.transportbackend.model.repository.ExpenseJpaRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService{


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ExpenseJpaRepo repository;

    @Override
    public List<ExpenseDTO> getAllExpense() {

        List<ExpenseDTO> expenseDTO = repository.findAll().stream()
                .map(expense -> modelMapper.map(expense, ExpenseDTO.class)).collect(Collectors.toList());
        return expenseDTO;
    }

    @Override
    public ExpenseDTO getExpenseById(UUID id) {
        try{
            Optional<ExpenseEntity> expense = repository.findById(id);
            ExpenseDTO expenseDTO = modelMapper.map(expense, ExpenseDTO.class);

            return expenseDTO;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public boolean createExpense(ExpenseDTO expenseDTO) {
        try{
            ExpenseEntity expense = modelMapper.map(expenseDTO, ExpenseEntity.class);
            repository.save(expense);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateExpense(ExpenseDTO expenseDTO) {
        try {
            ExpenseEntity expense = modelMapper.map(expenseDTO, ExpenseEntity.class);
            repository.save(expense);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean deleteExpense(UUID id) {
        try{
            ExpenseEntity expense = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("addres not found::" + id));
            repository.delete(expense);
            return true;
        }catch (ResourceNotFoundException e){
            e.printStackTrace();
            return false;
        }

    }
}
