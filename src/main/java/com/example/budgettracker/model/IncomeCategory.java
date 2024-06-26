package com.example.budgettracker.model;

public enum IncomeCategory implements OperationCategory {

    SALARY,
    DEPOSIT,
    FINANCIAL_OPERATIONS,
    OTHER;


    @Override
    public String getOperationType() {
        return OperationCategory.INCOME;
    }
}
