package com.example.budgettracker.web;

import com.example.budgettracker.dto.AccountDto;
import com.example.budgettracker.dto.UserDto;
import com.example.budgettracker.service.AccountService;
import com.example.budgettracker.util.authentication.AuthenticationFacade;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;
    private AuthenticationFacade auth;

    @Autowired
    public AccountController(AccountService accountService, AuthenticationFacade auth) {
        this.accountService = accountService;
        this.auth = auth;
    }

    @PostMapping
    public String addAccount(@RequestParam("description") String description,
                             @RequestParam("currency") String currency,
                             @RequestParam("amount") double amount) {
        Money money = Money.parse(currency + " " + amount);
        accountService.create(new AccountDto(null, money, description), auth.getUserDto().getId());
        return "redirect:dashboard";
    }

    @GetMapping
    public String accounts(Model model) {
        UserDto user = auth.getUserDto();
        model.addAttribute("accounts", accountService.getAll(user.getId()));
        return "accounts";
    }
}
