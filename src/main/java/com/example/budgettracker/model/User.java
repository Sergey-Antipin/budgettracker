package com.example.budgettracker.model;

import org.joda.money.Money;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class User {
    private String email;
    private LocalDate registrationDate;
    private Family family;
    private List<Account> accounts;
    private Map<OperationCategory, Money> expenseLimits;

    public User() {
    }

    public User(String email,
                LocalDate registrationDate,
                Family family,
                List<Account> accounts,
                Map<OperationCategory, Money> expenseLimits) {
        this.email = email;
        this.registrationDate = registrationDate;
        this.family = family;
        this.accounts = accounts;
        this.expenseLimits = expenseLimits;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public boolean addAccount(Account account) {
        return accounts.add(account);
    }

    public boolean removeAccount(Account account) {
        return accounts.remove(account);
    }

    public Map<OperationCategory, Money> getExpenseLimits() {
        return expenseLimits;
    }

    public void setExpenseLimits(Map<OperationCategory, Money> expenseLimits) {
        this.expenseLimits = expenseLimits;
    }

    public Money addExpenseLimit( OperationCategory category, Money limit) {
        return expenseLimits.put(category, limit);
    }

    public Money removeExpenseLimit( OperationCategory category) {
        return expenseLimits.remove(category);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                '}';
    }
}
