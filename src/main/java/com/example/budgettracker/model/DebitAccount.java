package com.example.budgettracker.model;

import org.joda.money.Money;

import java.util.Currency;
import java.util.List;

public class DebitAccount implements Account {

    private Money balance;
    private String description;
    private User user;
    private List<Operation> operations;

    public DebitAccount() {}

    public DebitAccount(Money balance, String description, User user, List<Operation> operations) {
        this.balance = balance;
        this.description = description;
        this.user = user;
        this.operations = operations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean addOperation(Operation operation) {
        return operations.add(operation);
    }

    public boolean removeOperation(Operation operation) {
        return operations.remove(operation);
    }

    public Currency getCurrency() {
        return balance.getCurrencyUnit().toCurrency();
    }
    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DebitAccount{" +
                "balance=" + balance +
                ", description='" + description + '\'' +
                '}';
    }
}
