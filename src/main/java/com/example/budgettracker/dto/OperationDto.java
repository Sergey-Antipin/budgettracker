package com.example.budgettracker.dto;

import com.example.budgettracker.model.Operation;
import com.example.budgettracker.model.OperationCategory;
import jakarta.validation.constraints.NotNull;
import org.joda.money.Money;

import java.time.LocalDate;
import java.util.Objects;

public class OperationDto {

    private Integer id;

    @NotNull
    private Money money;

    @NotNull
    private LocalDate date;

    private String description;

    @NotNull
    private OperationCategory category;

    private boolean excess;

    @NotNull
    private int accountId;

    public OperationDto(Integer id, Money money, LocalDate date, String description, OperationCategory category, boolean excess, int accountId) {
        this.id = id;
        this.money = money;
        this.date = date;
        this.description = description;
        this.category = category;
        this.excess = excess;
        this.accountId = accountId;
    }

    public OperationDto(Operation operation, boolean excess) {
        this.id = operation.getId();
        this.money = operation.getMoney();
        this.date = operation.getDate();
        this.description = operation.getDescription();
        this.category = operation.getCategory();
        this.excess = excess;
        this.accountId = operation.getAccount().getId();
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

    public int getAccountId() {
        return accountId;
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

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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
