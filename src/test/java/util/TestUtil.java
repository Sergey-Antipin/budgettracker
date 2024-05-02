package util;

import com.example.budgettracker.dto.UserDto;
import com.example.budgettracker.model.User;

import java.util.*;

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

    //https://www.baeldung.com/java-exception-root-cause
    public static Throwable getRootCause(Throwable throwable) {
        Objects.requireNonNull(throwable);
        Throwable rootCause = throwable;
        while (rootCause.getCause() != null && rootCause.getCause() != rootCause) {
            rootCause = rootCause.getCause();
        }
        return rootCause;
    }


}
