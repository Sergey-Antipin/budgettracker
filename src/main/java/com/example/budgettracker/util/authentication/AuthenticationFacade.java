package com.example.budgettracker.util.authentication;

import com.example.budgettracker.dto.UserDto;
import com.example.budgettracker.model.User;

public interface AuthenticationFacade {

    User getUser();

    UserDto getUserDto();
}
