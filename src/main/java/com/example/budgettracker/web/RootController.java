package com.example.budgettracker.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String root() {
        return "redirect:login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String authorize() {
        return "redirect:accounts";
    }

    @GetMapping("/accounts")
    public String accounts() {
        return "accounts";
    }
}
