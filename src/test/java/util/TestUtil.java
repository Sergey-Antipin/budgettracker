package util;

import com.example.budgettracker.dto.UserDto;
import com.example.budgettracker.model.Account;
import com.example.budgettracker.model.ExpenseOperation;
import com.example.budgettracker.model.Operation;
import com.example.budgettracker.model.User;
import org.joda.money.Money;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class TestUtil {

    public static int ADMIN_ID = 100000;
    public static int USER1_ID = 100001;
    public static int USER2_ID = 100002;

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

    public static Operation op1 = new ExpenseOperation(100012, Money.parse("RUB -30000.00"), )

    public static Account user2bankAccount = new Account(100005, Money.parse("RUB 50000.00"), "user2 bank account", )

    public static User USER2 = new User(100002,
            "user2@mail.ru",
            "user2password",
            new SimpleDateFormat("yyyy-MM-dd").parse("20204-03-01"),
            );

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
