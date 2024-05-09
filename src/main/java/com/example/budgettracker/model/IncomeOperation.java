package com.example.budgettracker.model;

import com.example.budgettracker.util.validation.Income;
import com.example.budgettracker.util.validation.MoneyPositive;
import jakarta.persistence.*;
import org.joda.money.Money;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("income")
@MoneyPositive
public class IncomeOperation extends Operation {

    @Income
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
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
    public <T extends OperationCategory> T getCategory() {
        return (T) category;
    }

    @Override
    public <T extends OperationCategory> void setCategory(T category) {
        this.category = (IncomeCategory) category;
    }
}
