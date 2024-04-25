package com.example.budgettracker.util;

import com.example.budgettracker.dto.UserCreationDto;
import com.example.budgettracker.dto.UserDto;
import com.example.budgettracker.model.Role;
import com.example.budgettracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserMapper {

    private PasswordEncoder encoder;

    @Autowired
    public UserMapper(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public UserMapper() {
    }

    public UserDto toDto(User user) {
        return new UserDto(user.getId(),
                user.getEmail(),
                user.getExpenseLimits());
    }

    public User toUser(UserCreationDto dto) {
        return new User(null,
                dto.getPassword(),
                dto.getEmail(),
                new Date(),
                new ArrayList<>(),
                new HashMap<>(),
                new HashSet<>(Set.of(Role.USER)));
    }

    public PasswordEncoder getEncoder() {
        return encoder;
    }

    public void setEncoder(PasswordEncoder encoder) {
        this.encoder = encoder;
    }
}
