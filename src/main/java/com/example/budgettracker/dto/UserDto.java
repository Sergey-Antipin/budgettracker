package com.example.budgettracker.dto;

import com.example.budgettracker.model.ExpenseCategory;
import org.joda.money.Money;

import java.util.Map;
import java.util.Objects;

public class UserDto {

    private Integer id;

    private String email;

    private Map<ExpenseCategory, Money> expenseLimits;

    public UserDto(Integer id, String email, Map<ExpenseCategory, Money> expenseLimits) {
        this.id = id;
        this.email = email;
        this.expenseLimits = expenseLimits;
    }

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<ExpenseCategory, Money> getExpenseLimits() {
        return expenseLimits;
    }

    public void setExpenseLimits(Map<ExpenseCategory, Money> expenseLimits) {
        this.expenseLimits = expenseLimits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto userDTO)) return false;
        return Objects.equals(id, userDTO.id) &&
                Objects.equals(email, userDTO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", email='" + email;
    }
}
