package com.example.budgettracker.util;

import com.example.budgettracker.dto.UserDto;
import com.example.budgettracker.model.User;

public class UserUtil {

    public static UserDto createDto(User user) {
        return new UserDto(user.getId(),
                user.getEmail(),
                user.getExpenseLimits());
    }
}
