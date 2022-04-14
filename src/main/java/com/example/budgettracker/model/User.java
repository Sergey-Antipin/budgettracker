package com.example.budgettracker.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class User {
    private String email;
    private Family family;
    private Set<Role> roles;
    private Date registrationDate;
    private List<Account> accounts;
    private Set<SpendingLimit> limits;

    public User() {}

    public User(String email,
                Family family,
                Set<Role> roles,
                Date registrationDate,
                List<Account> accounts,
                Set<SpendingLimit> limits) {
        this.email = email;
        this.family = family;
        this.roles = roles;
        this.registrationDate = registrationDate;
        this.accounts = accounts;
        this.limits = limits;
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Set<SpendingLimit> getLimits() {
        return limits;
    }

    public void setLimits(Set<SpendingLimit> limits) {
        this.limits = limits;
    }

    public boolean addLimit(SpendingLimit limit) {
        return limits.add(limit);
    }

    public boolean removeLimit(SpendingLimit limit) {
        return limits.remove(limit);
    }

    public boolean addAccount(Account account) {
        return accounts.add(account);
    }

    public boolean removeAccount(Account account) {
        return accounts.remove(account);
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
