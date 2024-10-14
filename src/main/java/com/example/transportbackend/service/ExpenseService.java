package com.example.transportbackend.service;

import com.example.transportbackend.model.dto.ExpenseDTO;

import java.util.List;
import java.util.UUID;

public interface ExpenseService {
    List<ExpenseDTO> getAllExpense();

    ExpenseDTO getExpenseById(UUID id);

    boolean createExpense(ExpenseDTO expenseDTO);

    boolean updateExpense(ExpenseDTO expenseDTO);

    boolean deleteExpense(UUID id);
}
