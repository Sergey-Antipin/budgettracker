package com.example.budgettracker.util.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.joda.money.Money;

public class MoneyNegativeTypeUseValidator implements ConstraintValidator<MoneyNegative, Money> {

    @Override
    public boolean isValid(Money value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value.isNegative();
    }
}
