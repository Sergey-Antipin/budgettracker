package com.example.budgettracker.util.authentication;

import com.example.budgettracker.model.User;
import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {

    Authentication getAuthentication();

    User getUser();
}
