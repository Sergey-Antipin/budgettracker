package com.example.budgettracker.dto;

import com.example.budgettracker.model.Account;
import com.example.budgettracker.model.OperationCategory;
import org.joda.money.Money;

import java.time.LocalDate;
import java.util.Objects;

public class OperationDto {

    private Integer id;

    private Money money;

    private LocalDate date;

    private String description;

    private OperationCategory category;

    private boolean excess;

    private Account account;

    public OperationDto(Integer id, Money money, LocalDate date, String description, OperationCategory category, boolean excess, Account account) {
        this.id = id;
        this.money = money;
        this.date = date;
        this.description = description;
        this.category = category;
        this.excess = excess;
        this.account = account;
    }

    public OperationDto() {
    }

    public Integer getId() {
        return id;
    }

    public Money getMoney() {
        return money;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public OperationCategory getCategory() {
        return category;
    }

    public boolean isExcess() {
        return excess;
    }

    public Account getAccount() {
        return account;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(OperationCategory category) {
        this.category = category;
    }

    public void setExcess(boolean excess) {
        this.excess = excess;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OperationDto that)) return false;
        return excess == that.excess &&
                Objects.equals(id, that.id) &&
                Objects.equals(money, that.money) &&
                Objects.equals(date, that.date) &&
                Objects.equals(description, that.description) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, money, date, description, category, excess);
    }

    @Override
    public String toString() {
        return "OperationDto{" +
                "amount=" + money +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", operationCategory=" + category +
                ", excess=" + excess +
                '}';
    }
}
