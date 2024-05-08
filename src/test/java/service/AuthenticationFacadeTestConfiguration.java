package service;

import com.example.budgettracker.util.authentication.AuthenticationFacade;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class AuthenticationFacadeTestConfiguration {

    @Bean
    @Primary
    public AuthenticationFacade authFacade() {
        return Mockito.mock(AuthenticationFacade.class);
    }
}
