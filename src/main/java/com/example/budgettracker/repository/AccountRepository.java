package com.example.budgettracker.repository;

import com.example.budgettracker.model.Account;

import java.util.List;

public interface AccountRepository {

    Account save(Account account);

    boolean delete(Account account);

    Account get(int id);

    List<Account> getAll();
}
