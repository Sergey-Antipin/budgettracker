package com.example.budgettracker.model;

import org.joda.money.Money;

import java.util.Date;
import java.util.Objects;

public class SpendingLimit {

    private Date startDate;
    private Date endDate;
    private ExpenseCategory expenseCategory;
    private Money limit;
    private User user;

    public SpendingLimit() {
    }

    public SpendingLimit(Date startDate, Date endDate, ExpenseCategory expenseCategory, Money limit, User user) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.expenseCategory = expenseCategory;
        this.limit = limit;
        this.user = user;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public Money getLimit() {
        return limit;
    }

    public void setLimit(Money limit) {
        this.limit = limit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpendingLimit that = (SpendingLimit) o;
        return startDate.equals(that.startDate) && endDate.equals(that.endDate)
                && expenseCategory == that.expenseCategory && limit.equals(that.limit)
                && user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, expenseCategory, limit, user);
    }

    @Override
    public String toString() {
        return "SpendingLimit{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", expenseCategory=" + expenseCategory +
                ", limit=" + limit +
                ", user=" + user +
                '}';
    }
}
