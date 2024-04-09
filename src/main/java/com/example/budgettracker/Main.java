package com.example.budgettracker;

import com.example.budgettracker.model.*;
import com.example.budgettracker.dto.AccountDTO;
import com.example.budgettracker.dto.OperationDTO;
import com.example.budgettracker.dto.UserDTO;
import com.example.budgettracker.util.OperationUtil;
import org.joda.money.Money;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static User USER = new User(1,"antipin@mail.ru", new Date(), new ArrayList<>(), new HashMap<>());
    public static UserDTO USERDTO;

    static {
        Account account = new Account(100000, Money.parse("RUB 20000"), "Наличные", new ArrayList<>());
        USER.addAccount(account);
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
        List<OperationDTO> opsDTO = OperationUtil.getDTOList(Arrays.asList(ops), USER.getExpenseLimits());
        AccountDTO accountDTO = new AccountDTO(Money.parse("RUB 20000"), "Наличные", opsDTO);
        List<AccountDTO> accountDTOList = new ArrayList<>();
        accountDTOList.add(accountDTO);
        USERDTO = new UserDTO(accountDTOList);
    }

    public static void main(String[] args) {
        List<Operation> ops = USER.getAccounts()
                .stream()
                .map(Account::getOperations)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        List<OperationDTO> dtos = OperationUtil.getDTOList(ops, USER.getExpenseLimits());
        dtos.forEach(System.out::println);
    }
}
