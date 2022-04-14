package com.example.budgettracker.model;

import org.joda.money.Money;

import java.time.LocalDateTime;

public class Withdraw extends AbstractOperation {

    public Withdraw() {}

    public Withdraw(Money sum, LocalDateTime dateTime, String description, Account account) {
        super(sum, dateTime, description, account);
    }

    @Override
    public Money process() {
        return account.getBalance().minus(sum);
    }

    @Override
    public String toString() {
        return "Withdraw{" +
                "sum=" + sum +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }
}
