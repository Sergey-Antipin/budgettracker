package com.example.budgettracker.model;

import org.joda.money.Money;

import java.time.LocalDate;

public class Operation {

    private Money amount;
    private LocalDate date;
    private String description;
    private OperationCategory operationCategory;

    public Operation(Money amount, LocalDate date, String description, OperationCategory operationCategory) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.operationCategory = operationCategory;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OperationCategory getOperationCategory() {
        return operationCategory;
    }

    public void setOperationCategory(OperationCategory operationCategory) {
        this.operationCategory = operationCategory;
    }
}
