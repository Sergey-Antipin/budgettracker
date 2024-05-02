package com.example.budgettracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.CompositeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "accounts")
public class Account extends AbstractBaseEntity {

    @NotNull
    @CompositeType(MoneyCompositeType.class)
    @Columns(columns = {@Column(name = "amount"), @Column(name = "currency")})
    private Money balance;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "account")
    @Fetch(FetchMode.JOIN)
    @OrderBy("date DESC")
    private List<Operation> operations;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", updatable = false)
    private User user;

    public Account() {
    }

    public Account(Integer id, Money balance, String description, List<Operation> operations) {
        super(id);
        this.balance = balance;
        this.description = description;
        this.operations = operations;
    }

    public CurrencyUnit getCurrency() {
        return balance.getCurrencyUnit();
    }

    public BigDecimal getAmount() {
        return balance.getAmount();
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), balance, description, operations, user);
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", description='" + description + '\'' +
                '}';
    }
}
