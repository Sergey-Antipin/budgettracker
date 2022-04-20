package com.example.budgettracker.model;

import org.joda.money.Money;

import java.time.LocalDate;

public class Recharge extends AbstractOperation {

    public Recharge() {}

    public Recharge(Money sum, LocalDate date, String description, Account account) {
        super(sum, date, description, account);
    }

    @Override
    public Money process() {
        return account.getBalance().plus(sum);
    }

    @Override
    public String toString() {
        return "Recharge{" +
                "sum=" + sum +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
