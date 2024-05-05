package com.example.budgettracker.model;

public enum IncomeCategory implements OperationCategory {

    SALARY,
    DEPOSIT,
    FINANCIAL_OPERATIONS,
    OTHER;

    public final static String OPERATION_TYPE = "income";

    @Override
    public String getOperationType() {
        return OPERATION_TYPE;
    }
}
