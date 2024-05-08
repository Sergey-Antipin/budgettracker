package service;

import com.example.budgettracker.model.ExpenseCategory;
import com.example.budgettracker.service.OperationService;
import com.example.budgettracker.util.authentication.AuthenticationFacade;
import org.assertj.core.api.Assertions;
import org.joda.money.Money;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashMap;
import java.util.Map;

@ActiveProfiles("test")
public class OperationServiceTest extends AbstractServiceTest {

    @Autowired
    private OperationService service;

    @Autowired
    private AuthenticationFacade auth;

    public void getAll() {
        Map<ExpenseCategory, Money> limits = new HashMap<>();

        /*limits.put(ExpenseCategory.CAR, Money.parse("RUB -5000.00"));
        int[] accountsId = {100004};
        Assertions.assertThat(service.getAll(accountsId))
                .hasSize(4);*/
        Mockito.when(auth.getUser()).thenReturn()
        Assertions.assertThat()
    }
}
