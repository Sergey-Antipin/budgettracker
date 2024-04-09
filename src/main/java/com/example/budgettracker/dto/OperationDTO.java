package com.example.budgettracker.dto;

import com.example.budgettracker.model.OperationCategory;
import org.joda.money.Money;

import java.time.LocalDate;

public class OperationDTO {
    private Money money;
    private LocalDate date;
    private String description;
    private String operationCategory;
    private boolean excess;

    public OperationDTO(Money money, LocalDate date, String description, OperationCategory operationCategory, boolean excess) {
        this.money = money;
        this.date = date;
        this.description = description;
        this.operationCategory = operationCategory.toString();
        this.excess = excess;
    }

    public OperationDTO() {
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

    @Override
    public String toString() {
        return "OperationDTO{" +
                "amount=" + money +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", operationCategory=" + operationCategory +
                ", excess=" + excess +
                '}';
    }
}
