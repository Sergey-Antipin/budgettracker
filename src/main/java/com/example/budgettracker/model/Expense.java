package com.example.budgettracker.model;

import org.joda.money.Money;

import java.time.LocalDate;

public class Expense extends Operation {

    private ExpenseCategory expenseCategory;

    public Expense() {
    }

    public Expense(Money amount, LocalDate date, String description, ExpenseCategory expenseCategory) {
        super(amount, date, description);
        this.expenseCategory = expenseCategory;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseCategory=" + expenseCategory +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
