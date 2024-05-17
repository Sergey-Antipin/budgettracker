package com.example.budgettracker.web;

import com.example.budgettracker.dto.AccountDto;
import com.example.budgettracker.dto.OperationDto;
import com.example.budgettracker.dto.UserDto;
import com.example.budgettracker.service.AccountService;
import com.example.budgettracker.service.OperationService;
import com.example.budgettracker.util.authentication.AuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private OperationService operationService;
    private AccountService accountService;
    private AuthenticationFacade auth;

    @Autowired
    public DashboardController(OperationService operationService, AccountService accountService, AuthenticationFacade auth) {
        this.operationService = operationService;
        this.accountService = accountService;
        this.auth = auth;
    }

    @GetMapping
    public String accounts(Model model,
                           @RequestParam(value = "startDate", defaultValue = "#{T(java.time.LocalDate).now().withDayOfMonth(1)}")
                           @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                           @RequestParam(value = "endDate", defaultValue = "#{T(java.time.LocalDate).now()}")
                           @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        //LocalDate end = LocalDate.now();
        //LocalDate start = end.withDayOfMonth(1);
        UserDto user = auth.getUserDto();
        List<AccountDto> accounts = accountService.getAll(user.getId());
        List<OperationDto> operations = operationService
                .getByPeriod(accounts.stream()
                        .map(AccountDto::getId)
                        .collect(Collectors.toList()), startDate, endDate);
        model.addAttribute("accounts", accounts);
        model.addAttribute("operations", operations);
        return "dashboard";
    }
}
