package com.example.budgettracker.repository;

import com.example.budgettracker.model.Operation;

import java.util.List;

public interface OperationRepository {

    Operation save(Operation operation);

    boolean delete(Operation operation);

    Operation get(int id);

    List<Operation> getAll();
}
