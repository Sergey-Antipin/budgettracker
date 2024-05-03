package com.example.budgettracker.web;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String root(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/accounts";
        }
        return "redirect:profile/login";
    }

    @GetMapping("/accounts")
    public String accounts() {
        return "accounts";
    }
}
