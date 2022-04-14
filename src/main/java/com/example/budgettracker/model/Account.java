package com.example.budgettracker.model;

import org.joda.money.Money;

import java.util.Currency;

public interface Account {

    boolean addOperation(Operation operation);

    boolean removeOperation(Operation operation);

    Money getBalance();

    Currency getCurrency();

}
