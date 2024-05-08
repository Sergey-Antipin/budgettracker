package util;

import com.example.budgettracker.dto.UserDto;
import com.example.budgettracker.model.*;
import org.joda.money.Money;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class TestUtil {

    public static int ADMIN_ID = 100000;
    public static int USER1_ID = 100001;
    public static int USER2_ID = 100002;

    public static Operation op1 = new ExpenseOperation(100012, Money.parse("RUB -30000.00"), LocalDate.parse("2024-02-18"), "снятие наличных", ExpenseCategory.FINANCIAL_OPERATIONS);
    public static Operation op2 = new IncomeOperation(100013, Money.parse("RUB 30000.00"), LocalDate.parse("2024-02-18"), "снятие наличных", IncomeCategory.FINANCIAL_OPERATIONS);
    public static Operation op3 = new ExpenseOperation(100014, Money.parse("RUB -9000.00"), LocalDate.parse("2024-03-08"), "подарки", ExpenseCategory.GIFTS);
    public static Operation op4 = new ExpenseOperation(100015, Money.parse("RUB -2000.00"), LocalDate.parse("2024-03-09"), "еще подарки", ExpenseCategory.GIFTS);
    public static Account user2bankAccount = new Account(100005, Money.parse("RUB 50000.00"), "user2 bank account", new ArrayList<>());
    public static Account user2cashAccount = new Account(100006, Money.parse("RUB 30000.00"), "user2 cash account", new ArrayList<>());
    public static User user2 = new User(100002,"user2@mail.ru","user2password", getDate("2024-01-03"), new ArrayList<>(), new HashMap<>(), Set.of(Role.USER));
    public static UserDto user2dto = new UserDto(100002, "user2@mail.ru", "user2password", new HashMap<>());
    static {
        op1.setAccount(user2bankAccount);
        op2.setAccount(user2cashAccount);
        op3.setAccount(user2cashAccount);
        op4.setAccount(user2bankAccount);
        user2cashAccount.getOperations().add(op2);
        user2cashAccount.getOperations().add(op3);
        user2bankAccount.getOperations().add(op1);
        user2bankAccount.getOperations().add(op4);
        user2.getAccounts().add(user2bankAccount);
        user2.getAccounts().add(user2cashAccount);
        user2.getExpenseLimits().put(ExpenseCategory.GIFTS, Money.parse("RUB -10000.00"));
        user2dto.getExpenseLimits().put(ExpenseCategory.GIFTS, Money.parse("RUB -10000.00"));
    }

    public static User createUser() {
        return new User(null, "test@mail.ru",
                "testpassword",
                new Date(),
                new ArrayList<>(),
                new HashMap<>(),
                new HashSet<>());
    }

    public static UserDto createUserDto() {
        return new UserDto(null, "test@mail.ru", "testpassword", new HashMap<>());
    }

    private static Date getDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }



    /*https://www.baeldung.com/java-exception-root-cause
    public static Throwable getRootCause(Throwable throwable) {
        Objects.requireNonNull(throwable);
        Throwable rootCause = throwable;
        while (rootCause.getCause() != null && rootCause.getCause() != rootCause) {
            rootCause = rootCause.getCause();
        }
        return rootCause;
    }*/


}
