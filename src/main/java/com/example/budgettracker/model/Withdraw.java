package com.example.budgettracker.model;

import org.joda.money.Money;

import java.time.LocalDate;

public class Withdraw extends AbstractOperation {

    public Withdraw() {}

    public Withdraw(Money sum, LocalDate date, String description, Account account) {
        super(sum, date, description, account);
    }

    @Override
    public Money process() {
        return account.getBalance().minus(sum);
    }

    @Override
    public String toString() {
        return "Withdraw{" +
                "sum=" + sum +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
