package com.example.budgettracker.model;

import org.joda.money.Money;

import java.util.Currency;
import java.util.List;

public interface Account {

    boolean addOperation(Operation operation);

    boolean removeOperation(Operation operation);

    Money getBalance();

    Currency getCurrency();

    List<Operation> getOperations();

}
