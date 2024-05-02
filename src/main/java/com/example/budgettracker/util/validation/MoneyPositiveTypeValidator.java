package com.example.budgettracker.util.validation;

import com.example.budgettracker.model.Operation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MoneyPositiveTypeValidator implements ConstraintValidator<MoneyPositive, Operation> {

    @Override
    public boolean isValid(Operation value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value.getMoney().isPositive();
    }
}
