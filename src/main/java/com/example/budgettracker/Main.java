package com.example.budgettracker;

import com.example.budgettracker.model.Withdraw;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Withdraw(Money.of(CurrencyUnit.USD, 10), LocalDateTime.now(), "test", null));
    }
}
