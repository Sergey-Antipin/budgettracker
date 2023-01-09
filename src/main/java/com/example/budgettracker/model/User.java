package com.example.budgettracker.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class User {
    private String email;
    private Family family;
    private Set<Role> roles;
    private LocalDate registrationDate;

    private List<Account> accounts;

    public User() {
    }

    public User(String email,
                Family family,
                Set<Role> roles,
                LocalDate registrationDate,
                List<Account> accounts,
                Set<ExpenseLimit> expenseLimits) {
        this.email = email;
        this.family = family;
        this.roles = roles;
        this.registrationDate = registrationDate;
        this.accounts = accounts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
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



    public boolean addRole(Role role) {
        return roles.add(role);
    }

    public boolean removeRole(Role role) {
        return roles.remove(role);
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
