package service;

import com.example.budgettracker.dto.UserDto;
import com.example.budgettracker.model.ExpenseCategory;
import com.example.budgettracker.model.User;
import com.example.budgettracker.service.UserService;
import com.example.budgettracker.util.exception.NotFoundException;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static util.TestUtil.*;

class UserServiceTest extends AbstractServiceTest {

    @Autowired
    private UserService service;

    @Test
    void create() {
        User newUser = createUser();
        UserDto newUserDto = createUserDto();
        User createdUser = service.create(newUserDto);
        newUser.setId(createdUser.getId());
        assertThat(createdUser).isEqualTo(newUser);
    }

    @Test
    void update() {
        UserDto userDto = service.get(USER1_ID);
        userDto.getExpenseLimits().put(ExpenseCategory.CLOTHES, Money.parse("USD -1000.00"));
        service.update(userDto);
        assertThat(service.get(USER1_ID).getExpenseLimits())
                .hasSize(2)
                .containsEntry(ExpenseCategory.CLOTHES, Money.parse("USD -1000.00"));
    }

    @Test
    void delete() {
        service.delete(USER1_ID);
        try {
            service.get(USER1_ID);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(NotFoundException.class);
        }
    }

    @Test
    void get() {
        assertThat(service.get(USER1_ID)).isNotNull();
    }

    @Test
    void getAll() {
        assertThat(service.getAll()).hasSize(3)
                .contains(service.get(ADMIN_ID), service.get(USER1_ID), service.get(USER2_ID));
    }

    @Test
    void createNotUniqueEmail() {
        try {
            service.create(new UserDto(null, "user1@mail.ru", "password", new HashMap<>()));
        } catch (Exception e) {
            assertThat(e).isInstanceOf(DataIntegrityViolationException.class)
                    .hasCauseInstanceOf(org.hibernate.exception.ConstraintViolationException.class)
                    .hasMessageContaining("duplicate key value violates unique constraint \"users_email_key\"");
        }
    }
}