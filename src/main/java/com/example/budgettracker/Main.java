package com.example.budgettracker;

import com.example.budgettracker.dto.UserDto;
import com.example.budgettracker.model.*;
import com.example.budgettracker.dto.AccountDto;
import com.example.budgettracker.dto.OperationDto;
import com.example.budgettracker.util.OperationUtil;
import com.example.budgettracker.util.UserUtil;
import org.joda.money.Money;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static User USER = new User(1,"antipin@mail.ru", new Date(), new ArrayList<>(), new HashMap<>());
    public static UserDto USERDTO;
    public static AccountDto ACCOUNTDTO;
    public static List<OperationDto> OPSDTOLIST;

    static {
        Account account = new Account(100000, Money.parse("RUB 20000"), "Наличные", new ArrayList<>());
        USER.getAccounts().add(account);
        USER.addExpenseLimit(ExpenseCategory.CAR, Money.parse("RUB -3000"));
        Operation expense1 = new ExpenseOperation(null, Money.parse("RUB -1000"), LocalDate.of(2022, 3, 22), "Продукты", ExpenseCategory.GROCERIES);
        Operation expense2 = new ExpenseOperation(null, Money.parse("RUB -2550"), LocalDate.of(2022, 3, 28), null, ExpenseCategory.CAR);
        Operation recharge1 = new IncomeOperation(null, Money.parse("RUB 5000"), LocalDate.of(2022, 3, 5), "Аванс", IncomeCategory.DEPOSIT);
        Operation expense3 = new ExpenseOperation(null, Money.parse("RUB -300"), LocalDate.of(2022, 3, 18), "", ExpenseCategory.COMMUNICATIONS);
        Operation expense4 = new ExpenseOperation(null, Money.parse("RUB -10200"), LocalDate.of(2022, 4, 7), "кайфуем", ExpenseCategory.LEISURE);
        Operation recharge2 = new IncomeOperation(null, Money.parse("RUB 333333"), LocalDate.of(2022, 4, 19), null, IncomeCategory.SALARY);
        Operation expense5 = new ExpenseOperation(null, Money.parse("RUB -700"), LocalDate.of(2022, 3, 30), "дозаправка", ExpenseCategory.CAR);
        Operation[] ops = {expense1, expense2, recharge1, expense3, expense4, recharge2, expense5};
        Collections.addAll(account.getOperations(), ops);
        OPSDTOLIST= OperationUtil.getDtoList(Arrays.asList(ops), USER.getExpenseLimits());
        ACCOUNTDTO= new AccountDto(null, Money.parse("RUB 20000"), "Наличные");
        USERDTO = UserUtil.createDto(USER);
    }

    public static void main(String[] args) {
        List<Operation> ops = USER.getAccounts()
                .stream()
                .map(Account::getOperations)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        List<OperationDto> dtos = OperationUtil.getDtoList(ops, USER.getExpenseLimits());
        dtos.forEach(System.out::println);
    }
}
