package util;

import com.example.budgettracker.model.User;
import com.example.budgettracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;
import org.springframework.util.Assert;

public class WithMockCustomUserSecurityContextFactory
        implements WithSecurityContextFactory<WithMockCustomUser> {

    private UserRepository repository;

    @Autowired
    public WithMockCustomUserSecurityContextFactory(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public SecurityContext createSecurityContext(WithMockCustomUser withUser) {
        String username = withUser.value();
        Assert.notNull(username, () -> withUser + " cannot have null username");
        User principal = repository.getByEmail(username);
        Authentication authentication = new UsernamePasswordAuthenticationToken(principal, principal.getPassword(), principal.getAuthorities());
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        return context;
    }
}
