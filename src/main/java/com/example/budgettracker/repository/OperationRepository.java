package com.example.budgettracker.repository;

import com.example.budgettracker.model.Operation;

import java.time.LocalDate;
import java.util.List;

public interface OperationRepository {

    Operation save(Operation operation, int accountId);

    void delete(int id, int accountId);

    Operation get(int id, int accountId);

    List<Operation> getAll(List<Integer> accountsId);

    List<Operation> getByPeriod(List<Integer> accountsId, LocalDate start, LocalDate end);
}
