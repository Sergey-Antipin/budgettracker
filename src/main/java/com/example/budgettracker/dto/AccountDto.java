package com.example.budgettracker.dto;

import com.example.budgettracker.model.Account;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.joda.money.Money;

import java.util.Objects;

public class AccountDto {

    private Integer id;

    @NotNull
    private Money balance;

    @NotBlank
    private String description;

    public AccountDto(Integer id, Money balance, String description) {
        this.id = id;
        this.balance = balance;
        this.description = description;
    }

    public AccountDto(Account account) {
        this.id = account.getId();
        this.balance = account.getBalance();
        this.description = account.getDescription();
    }

    public AccountDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountDto that)) return false;
        return Objects.equals(id, that.id) &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, description);
    }
}
