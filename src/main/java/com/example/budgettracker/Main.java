package com.example.budgettracker;

import com.example.budgettracker.model.*;
import org.joda.money.Money;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        User user = new User("antipin@mail.ru", null, new HashSet<>(), LocalDate.now(), new ArrayList<>(), new HashSet<>());
        Account account = new DebitAccount(Money.parse("RUB 20000"), "Наличные", user, new ArrayList<>());
        user.addAccount(account);
        Operation withdraw1 = new Withdraw(Money.parse("RUB 1000"), LocalDate.of(2022, 2, 22), "Продукты", account, ExpenseCategory.GROCERIES);
        Operation withdraw2 = new Withdraw(Money.parse("RUB 2550"), LocalDate.of(2022, 2, 28), null, account, ExpenseCategory.CAR);
        Operation recharge1 = new Recharge(Money.parse("RUB 5000"), LocalDate.of(2022, 3, 5), "Аванс", account);
        Operation withdraw3 = new Withdraw(Money.parse("RUB 300"), LocalDate.of(2022, 3, 18), "", account, ExpenseCategory.COMMUNICATIONS);
        Operation withdraw4 = new Withdraw(Money.parse("RUB 10200"), LocalDate.of(2022, 4, 7), "кайфуем", account, ExpenseCategory.LEISURE);
        Operation recharge2 = new Recharge(Money.parse("RUB 333333"), LocalDate.of(2022, 4, 19), null, account);
        Operation[] ops = {withdraw1, withdraw2, recharge1, withdraw3, withdraw4, recharge2};
        Collections.addAll(account.getOperations(), ops);


    }
}
