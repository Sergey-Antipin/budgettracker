package com.example.budgettracker.model;

import org.joda.money.Money;

import java.time.LocalDate;

public class Recharge extends Operation {

    public Recharge() {
    }

    public Recharge(Money amount, LocalDate date, String description) {
        super(amount, date, description);
    }

    @Override
    public String toString() {
        return "Recharge{" +
                "amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
