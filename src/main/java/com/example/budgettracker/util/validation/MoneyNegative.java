package com.example.budgettracker.util.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE, FIELD, TYPE_USE})
@Constraint(validatedBy = {MoneyNegativeTypeValidator.class, MoneyNegativeTypeUseValidator.class})
@Retention(RUNTIME)
public @interface MoneyNegative {

    String message() default "Money must be negative";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
