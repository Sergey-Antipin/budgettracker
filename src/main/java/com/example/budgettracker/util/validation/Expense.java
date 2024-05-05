package com.example.budgettracker.util.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({PARAMETER, FIELD})
@Constraint(validatedBy = ExpenseValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Expense {

    String message() default "OperationCategory must be of type: ExpenseOperation";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
