package service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ExtendWith(MockitoExtension.class)
@SpringJUnitConfig(locations = {"/spring/*.xml"})
@Sql("/db/populate_db.sql")
public class AbstractServiceTest {
}