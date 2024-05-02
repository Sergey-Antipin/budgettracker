package com.example.budgettracker.service;

import com.example.budgettracker.model.Account;
import com.example.budgettracker.repository.AccountRepository;
import com.example.budgettracker.util.exception.EntityAccessException;
import com.example.budgettracker.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Autowired
    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account create(Account account, int userId) {
        Assert.notNull(account, "passed account is null");
        return repository.save(account, userId);
    }

    @Override
    public void update(Account account, int userId) {
        Assert.notNull(account, "passed account is null");
        repository.save(account, userId);
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
    public List<Account> getAll(int userId) {
        return repository.getAll(userId);
    }
}
