package com.example.budgettracker.model;

import org.joda.money.Money;

import java.time.LocalDate;

public abstract class Operation {

    protected Money amount;
    protected LocalDate date;
    protected String description;

    public Operation() {
    }

    public Operation(Money amount, LocalDate date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
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
}
