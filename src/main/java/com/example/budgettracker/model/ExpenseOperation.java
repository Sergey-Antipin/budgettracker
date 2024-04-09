package com.example.budgettracker.model;

import com.example.budgettracker.util.validation.MoneyNegative;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import org.joda.money.Money;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("expense")
@MoneyNegative
public class ExpenseOperation extends Operation {

    @NotNull
    @Enumerated(EnumType.STRING)
    private ExpenseCategory category;

    public ExpenseOperation() {
    }

    public ExpenseOperation(Integer id, Money amount, LocalDate date, String description, ExpenseCategory category) {
        super(id, amount, date, description);
        this.category = category;
    }

    @Override
    public OperationCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }
}
