package com.example.budgettracker.service;

import com.example.budgettracker.model.Operation;

import java.util.Date;
import java.util.List;

public interface OperationService {

    Operation create(Operation operation, int accountId);

    void update(Operation operation, int accountId);

    void delete(int id, int accountId);

    Operation get(int id, int accountId);

    List<Operation> getAll(int accountId);

    List<Operation> getByPeriod(int accountId, Date start, Date end);
}
