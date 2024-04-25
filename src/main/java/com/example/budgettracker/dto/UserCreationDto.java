package com.example.budgettracker.dto;

import com.example.budgettracker.model.Role;

import java.util.Set;

public class UserCreationDto {

    private String email;

    private String password;

    private Set<Role> roles;

    public UserCreationDto(String email, String password, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public UserCreationDto() {
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
