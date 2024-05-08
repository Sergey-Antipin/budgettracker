package com.example.budgettracker.service;

import com.example.budgettracker.dto.OperationDto;
import com.example.budgettracker.model.ExpenseCategory;
import com.example.budgettracker.model.Operation;
import com.example.budgettracker.model.User;
import com.example.budgettracker.repository.OperationRepository;
import com.example.budgettracker.util.OperationMapper;
import com.example.budgettracker.util.authentication.AuthenticationFacade;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("operationService")
public class OperationServiceImpl implements OperationService {

    private final OperationRepository repository;
    private final OperationMapper mapper;
    private final AuthenticationFacade auth;

    @Autowired
    public OperationServiceImpl(OperationRepository repository, OperationMapper mapper, AuthenticationFacade auth) {
        this.repository = repository;
        this.mapper = mapper;
        this.auth = auth;
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
        Operation opToUpdate = repository.get(dto.getId(), accountId);
        repository.save(mapper.updateFromDto(opToUpdate, dto), accountId);
    }

    @Override
    public void delete(int id, int accountId) {
        repository.delete(id, accountId);
    }

    @Override
    public OperationDto get(int id, int accountId, boolean excess) {
        return mapper.toDto(repository.get(id, accountId), excess);
    }

    @Override
    public List<OperationDto> getAll(int[] accountsId) {
        User user = auth.getUser();
        Map<ExpenseCategory, Money> limits = user.getExpenseLimits();
        return mapper.getDtoList(repository.getAll(accountsId), limits);
    }

    @Override
    public List<OperationDto> getByPeriod(int[] accountsId, Date start, Date end) {
        User user = auth.getUser();
        Map<ExpenseCategory, Money> limits = user.getExpenseLimits();
        return mapper.getDtoList(repository.getByPeriod(accountsId, start, end), limits);
    }
}
