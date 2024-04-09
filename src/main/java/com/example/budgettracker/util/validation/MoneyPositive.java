package com.example.budgettracker.util.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Constraint(validatedBy = MoneyPositiveValidator.class)
@Retention(RUNTIME)
public @interface MoneyPositive {

    //TODO resourse boundle
    //https://docs.jboss.org/hibernate/validator/5.0/reference/en-US/html/validator-customconstraints.html#validator-customconstraints-validator
    String message() default "Money must be positive";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
