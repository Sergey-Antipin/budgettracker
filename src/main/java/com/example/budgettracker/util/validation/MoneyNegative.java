package com.example.budgettracker.util.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Constraint(validatedBy = MoneyNegativeValidator.class)
@Retention(RUNTIME)
public @interface MoneyNegative {

    String message() default "Money must be negative";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
