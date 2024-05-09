package service;

import com.example.budgettracker.dto.OperationDto;
import com.example.budgettracker.model.Account;
import com.example.budgettracker.model.Operation;
import com.example.budgettracker.service.OperationService;
import com.example.budgettracker.service.OperationServiceImpl;
import com.example.budgettracker.util.authentication.AuthenticationFacade;
import com.example.budgettracker.util.authentication.AuthenticationFacadeImpl;
import com.example.budgettracker.util.exception.EntityAccessException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static util.TestUtil.*;

public class OperationServiceTest extends AbstractServiceTest {

    @Autowired
    @InjectMocks
    private OperationService service;

    @Mock
    private AuthenticationFacade authFacade;

    @Test
    public void getAll() {
        Mockito.when(authFacade.getUser()).thenReturn(user2dto);
        List<Integer> accountsId = user2.getAccounts().stream().map(Account::getId).toList();
        List<OperationDto> ops = service.getAll(accountsId);
        assertThat(ops).hasSize(4);
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
}
