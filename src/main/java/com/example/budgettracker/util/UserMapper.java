package com.example.budgettracker.util;

import com.example.budgettracker.dto.UserDto;
import com.example.budgettracker.model.Role;
import com.example.budgettracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

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
        Assert.notNull(user, "passed used is null");
        return new UserDto(user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getExpenseLimits());
    }

    public User createFromDto(UserDto dto) {
        return new User(null,
                dto.getEmail().trim().toLowerCase(),
                encoder.encode(dto.getPassword()),
                new Date(),
                new ArrayList<>(),
                new HashMap<>(),
                new HashSet<>(Set.of(Role.USER)));
    }

    public User updateFromDto(UserDto dto, User user) {
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setExpenseLimits(dto.getExpenseLimits());
        return user;
    }

    public List<UserDto> getDtoList(List<User> users) {
        return users.stream()
                .map(this::toDto)
                .toList();
    }
}
