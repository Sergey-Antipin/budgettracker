package com.example.budgettracker.util.validation;

import com.example.budgettracker.model.ExpenseCategory;
import com.example.budgettracker.model.OperationCategory;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExpenseValidator implements ConstraintValidator<Expense, OperationCategory> {

    @Override
    public boolean isValid(OperationCategory value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value instanceof ExpenseCategory;
    }
}
