package com.example.budgettracker.model;

import com.example.budgettracker.util.validation.MoneyNegative;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.*;
import org.joda.money.Money;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "users")
public class User extends AbstractBaseEntity implements UserDetails {

    @NotNull
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    @Column(name = "registration_date", updatable = false)
    private Date registrationDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "user")
    @Fetch(FetchMode.JOIN)
    private List<Account> accounts;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_expense_limits", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "expense_category")
    @MapKeyEnumerated(EnumType.STRING)
    @CompositeType(MoneyCompositeType.class)
    @Columns(columns = {@Column(name = "amount"), @Column(name = "currency")})
    private Map<@NotNull ExpenseCategory, @MoneyNegative Money> expenseLimits;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Set<Role> roles;

    public User() {
    }

    public User(Integer id,
                String email,
                String password,
                Date registrationDate,
                List<Account> accounts,
                Map<ExpenseCategory, Money> expenseLimits,
                Set<Role> roles) {
        super(id);
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.accounts = accounts;
        this.expenseLimits = expenseLimits;
        this.roles = roles;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registrationDate=" + registrationDate +
                ", accounts=" + accounts +
                ", expenseLimits=" + expenseLimits +
                ", roles=" + roles +
                ", id=" + id +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
