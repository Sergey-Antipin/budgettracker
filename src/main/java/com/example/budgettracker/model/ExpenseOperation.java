package com.example.budgettracker.model;

import com.example.budgettracker.util.validation.Expense;
import com.example.budgettracker.util.validation.MoneyNegative;
import jakarta.persistence.*;
import org.joda.money.Money;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("expense")
@MoneyNegative
public class ExpenseOperation extends Operation {

    @Expense
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private ExpenseCategory category;

    public ExpenseOperation() {
    }

    public ExpenseOperation(Integer id,
                            Money amount,
                            LocalDate date,
                            String description,
                            ExpenseCategory category) {
        super(id, amount, date, description);
        this.category = category;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ExpenseCategory getCategory() {
        return category;
    }

    @Override
    public void setCategory(@Expense OperationCategory category) {
        this.category = (ExpenseCategory) category;
    }
}
