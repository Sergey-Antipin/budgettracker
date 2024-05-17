package com.example.budgettracker.util.authentication;

import com.example.budgettracker.dto.UserDto;
import com.example.budgettracker.model.User;
import com.example.budgettracker.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("authFacade")
public class AuthenticationFacadeImpl implements AuthenticationFacade {

    private UserMapper mapper;

    @Autowired
    public AuthenticationFacadeImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public User getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            throw new RuntimeException("No authenticated user found");
        }
        return (User) auth.getPrincipal();
    }

    @Override
    public UserDto getUserDto() {
        return mapper.toDto(getUser());
    }
}

