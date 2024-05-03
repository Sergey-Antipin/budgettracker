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
    public Account create(AccountDto account, int userId) {
        Assert.notNull(account, "passed account is null");
        Account newAccount = mapper.createFromDto(account);
        return repository.save(newAccount, userId);
    }

    @Override
    public void update(AccountDto account, int userId) {
        Assert.notNull(account, "passed account is null");
        Account accountToUpdate = get(account.getId(), userId);
        repository.save(mapper.updateFromDto(account, accountToUpdate), userId);
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
    public Account get(int id, int userId) {
        Account account = null;
        try {
            account = repository.get(id, userId);
        } catch (EntityAccessException e) {
            //TODO EntityAccessException handling
        } catch (NotFoundException e) {
            //TODO NotFoundException handling
        }
        return account;
    }

    @Override
    public AccountDto getDto(int id, int userId) {
        return mapper.toDto(get(id, userId));
    }

    @Override
    public List<Account> getAll(int userId) {
        return repository.getAll(userId);
    }
}
