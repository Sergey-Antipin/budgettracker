package com.example.budgettracker.model;

import org.joda.money.Money;

import java.time.LocalDate;

public class Withdraw extends AbstractOperation {

    private ExpenseCategory expenseCategory;
    public Withdraw() {}

    public Withdraw(Money sum, LocalDate date, String description, Account account, ExpenseCategory expenseCategory) {
        super(sum, date, description, account);
        this.expenseCategory = expenseCategory;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    @Override
    public Money process() {
        return account.getBalance().minus(sum);
    }

    @Override
    public String toString() {
        return "Withdraw{" +
                "expenseCategory=" + expenseCategory +
                ", sum=" + sum +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
