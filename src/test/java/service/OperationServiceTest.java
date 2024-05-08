package service;

import com.example.budgettracker.dto.OperationDto;
import com.example.budgettracker.model.Account;
import com.example.budgettracker.service.OperationServiceImpl;
import com.example.budgettracker.util.authentication.AuthenticationFacadeImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import util.TestUtil;

import java.util.List;

public class OperationServiceTest extends AbstractServiceTest {

    @Autowired
    @InjectMocks
    private OperationServiceImpl service;

    @Mock
    private AuthenticationFacadeImpl authFacade;

    @Test
    public void getAll() {
        Mockito.when(authFacade.getUser()).thenReturn(TestUtil.user2dto);
        List<Integer> accountsId = TestUtil.user2.getAccounts().stream().map(Account::getId).toList();
        List<OperationDto> ops = service.getAll(accountsId);
        Assertions.assertThat(ops).hasSize(4);
    }
}
