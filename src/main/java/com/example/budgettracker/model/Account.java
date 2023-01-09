package com.example.budgettracker.model;

import org.joda.money.Money;

import java.util.Currency;
import java.util.List;
import java.util.Set;

public class Account {

    private Money balance;
    private String description;
    private User user;
    private List<Operation> operations;

    Set<ExpenseLimit> expenseLimits;

    public Account() {
    }

    public Account(Money balance, String description, User user, List<Operation> operations, Set<ExpenseLimit> expenseLimits) {
        this.balance = balance;
        this.description = description;
        this.user = user;
        this.operations = operations;
        this.expenseLimits = expenseLimits;
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

    public Set<ExpenseLimit> getExpenseLimits() {
        return expenseLimits;
    }

    public void setExpenseLimits(Set<ExpenseLimit> expenseLimits) {
        this.expenseLimits = expenseLimits;
    }

    public boolean addLimit(ExpenseLimit limit) {
        return expenseLimits.add(limit);
    }

    public boolean removeLimit(ExpenseLimit limit) {
        return expenseLimits.remove(limit);
    }

    @Override
    public String toString() {
        return "DebitAccount{" +
                "balance=" + balance +
                ", description='" + description + '\'' +
                '}';
    }
}
