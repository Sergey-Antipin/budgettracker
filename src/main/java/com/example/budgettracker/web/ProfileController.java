package com.example.budgettracker.web;

import com.example.budgettracker.dto.UserDto;
import com.example.budgettracker.model.User;
import com.example.budgettracker.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private UserService service;

    @Autowired
    public ProfileController(UserService service) {
        this.service = service;
    }

    public ProfileController() {
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("newUser") @Valid UserDto newUser, HttpServletRequest request, Errors errors) {
        if (errors.hasErrors()) {
            //TODO
        }
        service.create(newUser);
        return "redirect:/profile/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("newUser", new UserDto());
        return "login";
    }

    public UserService getService() {
        return service;
    }

    public void setService(UserService service) {
        this.service = service;
    }
}
