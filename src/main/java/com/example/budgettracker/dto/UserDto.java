package com.example.budgettracker.dto;

import com.example.budgettracker.model.ExpenseCategory;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.joda.money.Money;

import java.util.Map;
import java.util.Objects;

public class UserDto {

    private Integer id;

    @NotEmpty
    @Email(regexp = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$")
    private String email;

    @NotEmpty
    @NotBlank
    private String password;

    private Map<ExpenseCategory, Money> expenseLimits;

    public UserDto(Integer id, String email, String password, Map<ExpenseCategory, Money> expenseLimits) {
        this.id = id;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
