package com.example.budgettracker.service;

import com.example.budgettracker.dto.OperationDto;
import com.example.budgettracker.model.Operation;
import com.example.budgettracker.repository.OperationRepository;
import com.example.budgettracker.util.OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@Service("operationService")
public class OperationServiceImpl implements OperationService {

    private final OperationRepository repository;
    private final OperationMapper mapper;

    @Autowired
    public OperationServiceImpl(OperationRepository repository, OperationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Operation create(OperationDto dto, int accountId) {
        Assert.notNull(dto, "operation must not be null");
        Operation newOp = mapper.createFromDto(dto);
        return repository.save(newOp, accountId);
    }

    @Override
    public void update(OperationDto dto, int accountId) {
        Assert.notNull(dto, "operation must not be null");
        Operation opToUpdate = get(dto.getId(), accountId);
        repository.save(mapper.updateFromDto(opToUpdate, dto), accountId);
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
    public OperationDto getDto(int id, int accountId, boolean excess) {
        return mapper.toDto(get(id, accountId), excess);
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
