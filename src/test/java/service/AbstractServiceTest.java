package service;

import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = {"/spring/spring-app.xml", "/spring/spring-db.xml"})
@Sql("/db/populate_db.sql")
public class AbstractServiceTest {
}