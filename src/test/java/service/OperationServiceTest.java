package service;

import com.example.budgettracker.dto.OperationDto;
import com.example.budgettracker.model.Account;
import com.example.budgettracker.model.Operation;
import com.example.budgettracker.service.OperationService;
import com.example.budgettracker.util.exception.EntityAccessException;
import com.example.budgettracker.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import util.WithMockCustomUser;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static util.TestUtil.*;

public class OperationServiceTest extends AbstractServiceTest {

    @Autowired
    private OperationService service;

    @Test
    @WithMockCustomUser("user2@mail.ru")
    public void getAll() {
        List<Integer> accountsId = user2.getAccounts().stream().map(Account::getId).toList();
        List<OperationDto> ops = service.getAll(accountsId);
        assertThat(ops).hasSize(4);
        assertThat(ops).containsAll(List.of(op1dto, op2dto, op3dto, op4dto));
    }

    @Test
    public void create() {
        OperationDto newOperation = newOp;
        Operation created = service.create(newOperation, user2bankAccount.getId());
        newOperation.setId(created.getId());
        assertThat(created.getMoney()).isEqualTo(newOperation.getMoney());
        assertThat(created.getCategory().toString()).isEqualTo(newOperation.getCategory().toString());
    }

    @Test
    public void getWrongAccount() {
        try {
            service.get(op1.getId(), user1Account.getId());
        } catch (Exception e) {
            assertThat(e).isInstanceOf(EntityAccessException.class);
        }
    }

    @Test
    public void delete() {
        assertThat(service.get(op1.getId(), user2bankAccount.getId())).isEqualTo(op1dto);
        service.delete(op1.getId(), user2bankAccount.getId());
        try {
            service.get(op1.getId(), user2bankAccount.getId());
        } catch (Exception e) {
            assertThat(e).isInstanceOf(NotFoundException.class);
        }
    }
}
