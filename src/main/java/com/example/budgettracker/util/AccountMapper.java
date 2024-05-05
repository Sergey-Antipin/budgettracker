package com.example.budgettracker.util;

import com.example.budgettracker.dto.AccountDto;
import com.example.budgettracker.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountMapper() {
    }

    public AccountDto toDto(Account account) {
        return new AccountDto(account.getId(),
                account.getBalance(),
                account.getDescription());
    }

    public Account createFromDto(AccountDto dto) {
        return new Account(null,
                dto.getBalance(),
                dto.getDescription(),
                null);
    }

    public Account updateFromDto(Account account, AccountDto dto) {
        account.setBalance(dto.getBalance());
        account.setDescription(dto.getDescription());
        return account;
    }
}
