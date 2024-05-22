package com.example.budgettracker.web;

import com.example.budgettracker.dto.AccountDto;
import com.example.budgettracker.dto.OperationDto;
import com.example.budgettracker.dto.UserDto;
import com.example.budgettracker.model.ExpenseCategory;
import com.example.budgettracker.model.IncomeCategory;
import com.example.budgettracker.service.AccountService;
import com.example.budgettracker.service.OperationService;
import com.example.budgettracker.util.OperationMapper;
import com.example.budgettracker.util.authentication.AuthenticationFacade;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private OperationService operationService;
    private AccountService accountService;
    private AuthenticationFacade auth;
    private OperationMapper opMapper;

    @Autowired
    public DashboardController(OperationService operationService, AccountService accountService, AuthenticationFacade auth, OperationMapper opMapper) {
        this.operationService = operationService;
        this.accountService = accountService;
        this.auth = auth;
        this.opMapper = opMapper;
    }

    @GetMapping
    public String operations(Model model,
                             @RequestParam(value = "startDate", defaultValue = "#{T(java.time.LocalDate).now().withDayOfMonth(1)}")
                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                             @RequestParam(value = "endDate", defaultValue = "#{T(java.time.LocalDate).now()}")
                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        UserDto user = auth.getUserDto();
        List<AccountDto> accounts = accountService.getAll(user.getId());
        List<OperationDto> operations = operationService
                .getByPeriod(accounts.stream()
                        .map(AccountDto::getId)
                        .collect(Collectors.toList()), startDate, endDate);
        Map<Integer, String> accountDescriptions = accounts.stream()
                .collect(Collectors.toMap(AccountDto::getId, AccountDto::getDescription));
        model.addAttribute("accounts", accounts);
        model.addAttribute("operations", operations);
        model.addAttribute("newOp", new OperationDto());
        model.addAttribute("accountDescriptions", accountDescriptions);
        model.addAttribute("incomeCategories", IncomeCategory.values());
        model.addAttribute("expenseCategories", ExpenseCategory.values());
        return "dashboard";
    }

    @PostMapping
    public String addOperation(@RequestParam("accountId") int accountId,
                               @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                               @RequestParam("amount") double amount,
                               @RequestParam("category") String category,
                               @RequestParam("operationType") String operationType,
                               @RequestParam("description") String description) {
        int userId = auth.getUserDto().getId();
        CurrencyUnit currencyUnit = accountService.get(accountId, userId).getBalance().getCurrencyUnit();
        Money money = Money.of(currencyUnit, amount);
        OperationDto newOp = opMapper.createDto(money, date, description, operationType, category, accountId);
        operationService.create(newOp, accountId);
        return "redirect:dashboard";
    }
}
