package fundMe.services;

import fundMe.data.models.Role;
import fundMe.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LoanServiceImplTest {
    LoanService loanService;
    AuthenticationService authenticationService;
    @BeforeEach
    public void setUp() {
        loanService = new LoanServiceImpl();
        authenticationService = new AuthenticationServiceImpl();
    }


}