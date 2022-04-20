package com.example.budgettracker;

import com.example.budgettracker.model.Withdraw;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Withdraw withdraw = new Withdraw(Money.of(CurrencyUnit.USD, 10), LocalDate.now(), "test", null);
        //System.out.println(new Withdraw(Money.of(CurrencyUnit.USD, 10), LocalDate.now(), "test", null));
        log.debug("Hello {}", withdraw);
    }
}
