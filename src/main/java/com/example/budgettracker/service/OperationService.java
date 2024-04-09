package com.example.budgettracker.service;

import com.example.budgettracker.model.Operation;

import java.util.Date;
import java.util.List;

public interface OperationService {

    Operation create(Operation operation);

    void update(Operation operation, int accountId);

    void delete(Operation operation, int accountId);

    Operation get(Operation operation, int accountId);

    List<Operation> getAll(int accountId);

    List<Operation> getByPeriod(int accountId, Date start, Date end);
}
