package com.example.budgettracker.repository;

import com.example.budgettracker.model.Operation;

import java.util.Date;
import java.util.List;

public interface OperationRepository {

    Operation save(Operation operation, int accountId);

    boolean delete(Operation operation, int accountId);

    Operation get(int id, int accountId);

    List<Operation> getAll(int accountId);

    List<Operation> getByPeriod(int accountId, Date start, Date end);
}
