package com.example.budgettracker.service;

import com.example.budgettracker.model.Operation;
import com.example.budgettracker.repository.OperationRepository;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

public class OperationServiceImpl implements OperationService {

    private OperationRepository repository;

    @Override
    public Operation create(Operation operation, int accountId) {
        Assert.notNull(operation, "operation must not be null");
        return repository.save(operation, accountId);
    }

    @Override
    public void update(Operation operation, int accountId) {
        Assert.notNull(operation, "operation must not be null");
        repository.save(operation, accountId);
    }

    @Override
    public void delete(int id, int accountId) {
        repository.delete(id, accountId);
    }

    @Override
    public Operation get(int id, int accountId) {
        return repository.get(id, accountId);
    }

    @Override
    public List<Operation> getAll(int accountId) {
        return repository.getAll(accountId);
    }

    @Override
    public List<Operation> getByPeriod(int accountId, Date start, Date end) {
        return repository.getByPeriod(accountId, start, end);
    }
}
