package com.example.budgettracker.model;

import org.joda.money.Money;

import java.time.LocalDateTime;

public class Recharge extends AbstractOperation {

    public Recharge() {}

    public Recharge(Money sum, LocalDateTime dateTime, String description, Account account) {
        super(sum, dateTime, description, account);
    }

    @Override
    public Money process() {
        return account.getBalance().plus(sum);
    }

    @Override
    public String toString() {
        return "Recharge{" +
                "sum=" + sum +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }
}
