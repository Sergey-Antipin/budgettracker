package com.example.budgettracker.util.authentication;

import com.example.budgettracker.dto.UserDto;
import com.example.budgettracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component("authFacade")
public class AuthenticationFacadeImpl implements AuthenticationFacade {

    private UserService userService;

    @Autowired
    public AuthenticationFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto getUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name;
        if (principal instanceof UserDetails) {
            name = ((UserDetails) principal).getUsername();
        } else {
            name = principal.toString();
        }
        return userService.getByEmail(name);
    }
}

