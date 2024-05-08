package com.example.budgettracker.service;

import com.example.budgettracker.dto.AccountDto;
import com.example.budgettracker.model.Account;
import com.example.budgettracker.repository.AccountRepository;
import com.example.budgettracker.util.AccountMapper;
import com.example.budgettracker.util.exception.EntityAccessException;
import com.example.budgettracker.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final AccountMapper mapper;

    @Autowired
    public AccountServiceImpl(AccountRepository repository, AccountMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Account create(AccountDto dto, int userId) {
        Assert.notNull(dto, "passed dto is null");
        Account newAccount = mapper.createFromDto(dto);
        return repository.save(newAccount, userId);
    }

    @Override
    public void update(AccountDto dto, int userId) {
        Assert.notNull(dto, "passed dto is null");
        Account accountToUpdate = repository.get(dto.getId(), userId);
        repository.save(mapper.updateFromDto(accountToUpdate, dto), userId);
    }

    @Override
    public void delete(int id, int userId) {
        try {
            repository.delete(id, userId);
        } catch (EntityAccessException e) {
            //TODO EntityAccessException handling
        }
    }

    @Override
    public AccountDto get(int id, int userId) {
        return mapper.toDto(repository.get(id, userId));
    }

    @Override
    public List<AccountDto> getAll(int userId) {
        return mapper.getDtoList(repository.getAll(userId));
    }
}
