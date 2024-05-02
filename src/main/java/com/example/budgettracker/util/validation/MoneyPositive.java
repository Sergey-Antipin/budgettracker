package com.example.budgettracker.util.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE, FIELD, TYPE_USE})
@Constraint(validatedBy = MoneyPositiveTypeValidator.class)
@Retention(RUNTIME)
@NotNull
public @interface MoneyPositive {

    //TODO resourse boundle
    //https://docs.jboss.org/hibernate/validator/5.0/reference/en-US/html/validator-customconstraints.html#validator-customconstraints-validator
    String message() default "Money must be positive";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
