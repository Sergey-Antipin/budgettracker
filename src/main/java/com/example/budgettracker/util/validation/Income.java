package com.example.budgettracker.util.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({PARAMETER, FIELD})
@Constraint(validatedBy = IncomeValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Income {

    String message() default "OperationCategory must be of type: IncomeOperation";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
