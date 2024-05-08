package com.example.budgettracker.service;

import com.example.budgettracker.dto.AccountDto;
import com.example.budgettracker.model.Account;

import java.util.List;

public interface AccountService {

    Account create(AccountDto account, int userId);

    void update(AccountDto account, int userId);

    void delete(int id, int userId);

    AccountDto get(int id, int userId);

    List<AccountDto> getAll(int userId);
}
