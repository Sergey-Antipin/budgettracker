package com.example.budgettracker.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String root() {
        return "redirect:profile/login";
    }

    @GetMapping("/accounts")
    public String accounts() {
        return "accounts";
    }
}
