package com.example.budgettracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.CompositeType;
import org.joda.money.Money;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", length = 7)
@Table(name = "operations")
public abstract class Operation extends AbstractBaseEntity {

    @NotNull
    @CompositeType(MoneyCompositeType.class)
    @Columns(columns = {@Column(name = "amount"), @Column(name = "currency")})
    private Money money;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    protected Operation() {
    }

    public Operation(Integer id, Money money, LocalDate date, String description) {
        super(id);
        this.money = money;
        this.date = date;
        this.description = description;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public abstract OperationCategory getCategory();
}
