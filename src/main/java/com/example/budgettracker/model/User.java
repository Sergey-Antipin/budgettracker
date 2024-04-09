package com.example.budgettracker.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.*;
import org.joda.money.Money;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends AbstractBaseEntity {

    @NotNull
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    @Column(name = "registration_date", updatable = false)
    private Date registrationDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "user")
    @Fetch(FetchMode.JOIN)
    private List<Account> accounts;

    @ElementCollection
    @CollectionTable(name = "user_expense_limits", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @CompositeType(MoneyCompositeType.class)
    @Columns(columns = {@Column(name = "limit_amount"), @Column(name = "limit_currency")})
    private Map<@NotNull ExpenseCategory, @NotNull Money> expenseLimits;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Set<Role> roles;

    public User() {
    }

    public User(Integer id,
                String email,
                Date registrationDate,
                List<Account> accounts,
                Map<ExpenseCategory, Money> expenseLimits) {
        super(id);
        this.email = email;
        this.registrationDate = registrationDate;
        this.accounts = accounts;
        this.expenseLimits = expenseLimits;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Map<ExpenseCategory, Money> getExpenseLimits() {
        return expenseLimits;
    }

    public void setExpenseLimits(Map<ExpenseCategory, Money> expenseLimits) {
        this.expenseLimits = expenseLimits;
    }

    public Money addExpenseLimit(ExpenseCategory category, Money limit) {
        return expenseLimits.put(category, limit);
    }

    public Money removeExpenseLimit(ExpenseCategory category) {
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
