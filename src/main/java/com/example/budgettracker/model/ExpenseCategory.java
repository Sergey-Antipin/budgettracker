package com.example.budgettracker.model;

public enum ExpenseCategory implements OperationCategory {

    GROCERIES,
    CAR,
    TRANSPORT,
    HEALTH,
    LEISURE,
    CLOTHES,
    KIDS,
    HOUSE,
    SPORTS,
    COMMUNICATIONS,
    VACATION,
    GIFTS,
    FINANCIAL_OPERATIONS,
    OTHER;

    public final static String OPERATION_TYPE = "expense";


    @Override
    public String getOperationType() {
        return OPERATION_TYPE;
    }
}