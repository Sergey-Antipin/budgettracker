package com.example.budgettracker.model.dto;

import com.example.budgettracker.model.OperationCategory;
import org.joda.money.Money;

import java.time.LocalDate;

public class OperationDTO {
    private Money amount;
    private LocalDate date;
    private String description;
    private String operationCategory;
    private boolean excess;

    public OperationDTO(Money amount, LocalDate date, String description, OperationCategory operationCategory, boolean excess) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.operationCategory = operationCategory.toString();
        this.excess = excess;
    }

    public OperationDTO() {
    }

    public Money getAmount() {
        return amount;
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
                "amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", operationCategory=" + operationCategory +
                ", excess=" + excess +
                '}';
    }
}
