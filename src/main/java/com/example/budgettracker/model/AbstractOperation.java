package com.example.budgettracker.model;

import org.joda.money.Money;

import java.time.LocalDateTime;

public abstract class AbstractOperation implements Operation {

    protected Money sum;
    protected LocalDateTime dateTime;
    protected String description;
    protected Account account;

    public AbstractOperation() {}

    public AbstractOperation(Money sum, LocalDateTime dateTime, String description, Account account) {
        this.sum = sum;
        this.dateTime = dateTime;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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
