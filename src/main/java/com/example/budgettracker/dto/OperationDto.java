package com.example.budgettracker.dto;

import com.example.budgettracker.model.OperationCategory;
import org.joda.money.Money;

import java.time.LocalDate;
import java.util.Objects;

public class OperationDto {

    private Integer id;

    private Money money;

    private LocalDate date;

    private String description;

    private String operationCategory;

    private boolean excess;

    public OperationDto(Integer id, Money money, LocalDate date, String description, OperationCategory operationCategory, boolean excess) {
        this.id = id;
        this.money = money;
        this.date = date;
        this.description = description;
        this.operationCategory = operationCategory.toString();
        this.excess = excess;
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

    public String getOperationCategory() {
        return operationCategory;
    }

    public boolean isExcess() {
        return excess;
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

    public void setOperationCategory(String operationCategory) {
        this.operationCategory = operationCategory;
    }

    public void setExcess(boolean excess) {
        this.excess = excess;
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
                Objects.equals(operationCategory, that.operationCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, money, date, description, operationCategory, excess);
    }

    @Override
    public String toString() {
        return "OperationDto{" +
                "amount=" + money +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", operationCategory=" + operationCategory +
                ", excess=" + excess +
                '}';
    }
}
