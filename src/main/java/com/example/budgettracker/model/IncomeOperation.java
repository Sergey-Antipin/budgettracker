package com.example.budgettracker.model;

import com.example.budgettracker.util.validation.Income;
import com.example.budgettracker.util.validation.MoneyPositive;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import org.joda.money.Money;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("income")
@MoneyPositive
public class IncomeOperation extends Operation {

    @NotNull
    @Enumerated(EnumType.STRING)
    private IncomeCategory category;

    public IncomeOperation() {
    }

    public IncomeOperation(Integer id,
                           Money amount,
                           LocalDate date,
                           String description,
                           IncomeCategory category) {
        super(id, amount, date, description);
        this.category = category;
    }

    @Override
    @SuppressWarnings("unchecked")
    public IncomeCategory getCategory() {
        return category;
    }

    @Override
    public void setCategory(@Income OperationCategory category) {
        this.category = (IncomeCategory) category;
    }
}
