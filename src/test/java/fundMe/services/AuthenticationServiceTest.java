package fundMe.services;

import fundMe.data.models.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AuthenticationServiceTest {
    LoanService loanService;
    AuthenticationService authenticationService;
    @BeforeEach
    public void setUp() {
        loanService = new LoanServiceImpl();
        authenticationService = new AuthenticationServiceImpl();
    }

//    @Test
//    public void test_thatUserCanRegister(){
//        assertEquals(0, authenticationService.count());
//        String newUser= authenticationService.Register("John", "Ike", Role.BORROWER, "password");
//        assertEquals("Registered Successfully", newUser );
//        assertTrue(authenticationService.isRegistered());
//        assertEquals(1, authenticationService.count());
//    }
}