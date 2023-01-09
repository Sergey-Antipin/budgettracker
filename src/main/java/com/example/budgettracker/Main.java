package com.example.budgettracker;

import com.example.budgettracker.model.*;
import org.joda.money.Money;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static User USER = new User("antipin@mail.ru", null, new HashSet<>(), LocalDate.now(), new ArrayList<>(), new HashSet<>());

    static {
        Account account = new Account(Money.parse("RUB 20000"), "Наличные", USER, new ArrayList<>(), new HashSet<>());
        USER.addAccount(account);
        account.addLimit(new ExpenseLimit(LocalDate.of(2022, 3, 1), LocalDate.of(2022, 3, 31), ExpenseCategory.CAR, Money.parse("RUB 3000"), USER));
        Expense expense1 = new Expense(Money.parse("RUB 1000"), LocalDate.of(2022, 3, 22), "Продукты", ExpenseCategory.GROCERIES);
        Expense expense2 = new Expense(Money.parse("RUB 2550"), LocalDate.of(2022, 3, 28), null, ExpenseCategory.CAR);
        Recharge recharge1 = new Recharge(Money.parse("RUB 5000"), LocalDate.of(2022, 3, 5), "Аванс");
        Expense expense3 = new Expense(Money.parse("RUB 300"), LocalDate.of(2022, 3, 18), "", ExpenseCategory.COMMUNICATIONS);
        Expense expense4 = new Expense(Money.parse("RUB 10200"), LocalDate.of(2022, 4, 7), "кайфуем", ExpenseCategory.LEISURE);
        Recharge recharge2 = new Recharge(Money.parse("RUB 333333"), LocalDate.of(2022, 4, 19), null);
        Expense expense5 = new Expense(Money.parse("RUB 700"), LocalDate.of(2022, 3, 30), "дозаправка", ExpenseCategory.CAR);
        Operation[] ops = {expense1, expense2, recharge1, expense3, expense4, recharge2, expense5};
        Collections.addAll(account.getOperations(), ops);
    }

    public static void main(String[] args) {
        Money money1 = Money.parse("RUB 2500");
        Money money2 = Money.parse("RUB -500");
        System.out.println(money1.plus(money2));
    }
}
