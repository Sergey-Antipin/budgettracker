package com.example.budgettracker.service;

import com.example.budgettracker.dto.OperationDto;
import com.example.budgettracker.model.ExpenseCategory;
import com.example.budgettracker.model.Operation;
import com.example.budgettracker.model.User;
import com.example.budgettracker.repository.OperationRepository;
import com.example.budgettracker.util.OperationMapper;
import com.example.budgettracker.util.authentication.AuthenticationFacade;
import com.example.budgettracker.util.exception.NotFoundException;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service("operationService")
@Transactional(readOnly = true)
public class OperationServiceImpl implements OperationService {

    private OperationRepository repository;
    private OperationMapper mapper;
    private AuthenticationFacade auth;

    @Autowired
    public OperationServiceImpl(OperationRepository repository, OperationMapper mapper, AuthenticationFacade auth) {
        this.repository = repository;
        this.mapper = mapper;
        this.auth = auth;
    }

    @Override
    @Transactional
    public Operation create(OperationDto dto, int accountId) {
        Assert.notNull(dto, "operation must not be null");
        Operation newOp = mapper.createFromDto(dto);
        return repository.save(newOp, accountId);
    }

    @Override
    @Transactional
    public void update(OperationDto dto, int accountId) {
        Assert.notNull(dto, "operation must not be null");
        Operation opToUpdate = repository.get(dto.getId(), accountId);
        repository.save(mapper.updateFromDto(opToUpdate, dto), accountId);
    }

    @Override
    @Transactional
    public void delete(int id, int accountId) {
        repository.delete(id, accountId);
    }

    @Override
    public OperationDto get(int id, int accountId) {
        Operation op = repository.get(id, accountId);
        if (op == null) {
            throw new NotFoundException(id);
        }
        return mapper.toDto(op, false);
    }

    @Override
    public List<OperationDto> getAll(List<Integer> accountsId) {
        User user = auth.getUser();
        Map<ExpenseCategory, Money> limits = user.getExpenseLimits();
        return mapper.getDtoList(repository.getAll(accountsId), limits);
    }

    @Override
    public List<OperationDto> getByPeriod(List<Integer> accountsId, LocalDate start, LocalDate end) {
        User user = auth.getUser();
        Map<ExpenseCategory, Money> limits = user.getExpenseLimits();
        return mapper.getDtoList(repository.getByPeriod(accountsId, start, end), limits);
    }
}
