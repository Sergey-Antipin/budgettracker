package com.example.budgettracker.repository;

import com.example.budgettracker.model.Account;

import java.util.List;

public interface AccountRepository {

    Account save(Account account, int userId);

    void delete(int id, int userId);

    Account get(int id, int userId);

    List<Account> getAll(int userId);
}
