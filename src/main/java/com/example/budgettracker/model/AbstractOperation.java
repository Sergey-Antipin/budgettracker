package com.example.budgettracker.model;

import org.joda.money.Money;

import java.time.LocalDate;

public abstract class AbstractOperation implements Operation {

    protected Money sum;
    protected LocalDate date;
    protected String description;
    protected Account account;

    public AbstractOperation() {}

    public AbstractOperation(Money sum, LocalDate date, String description, Account account) {
        this.sum = sum;
        this.date = date;
        this.description = description;
        this.account = account;
    }

    public abstract Money process();

    public Money getSum() {
        return sum;
    }

    public void setSum(Money sum) {
        this.sum = sum;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
