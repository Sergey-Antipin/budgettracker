package com.example.budgettracker.model.dto;

import org.joda.money.Money;

import java.util.List;

public class AccountDTO {
    private Money balance;
    private String description;
    private List<OperationDTO> operations;

    public AccountDTO(Money balance, String description, List<OperationDTO> operations) {
        this.balance = balance;
        this.description = description;
        this.operations = operations;
    }

    public AccountDTO() {
    }

    public Money getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }

    public List<OperationDTO> getOperations() {
        return operations;
    }

    @Override
    public String toString() {
        return "DebitAccount{" +
                "balance=" + balance +
                ", description='" + description + '\'' +
                '}';
    }
}
