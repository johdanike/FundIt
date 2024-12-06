package fundMe.services;

import fundMe.data.models.Role;
import fundMe.data.repositories.UserRepository;
import fundMe.dtos.request.CreateAccountRequest;
import fundMe.dtos.request.LoginRequest;
import fundMe.dtos.response.CreateAccountResponse;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@SpringBootTest
public class AuthenticationServiceImplTest {

    @Autowired
    private AuthenticationService authenticationService;
    CreateAccountRequest createAccountRequest;

    @Autowired
    UserRepository userRepository;
    @BeforeEach
    void setUp() {

        userRepository.deleteAll();

        createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setFirstName("Iam");
        createAccountRequest.setLastName("Fabulous");
        createAccountRequest.setUsername("iamFabulous");
        createAccountRequest.setPassword("123456");
        createAccountRequest.setNIN("123456789");
        createAccountRequest.setEmail("test@test.com");

    }

    @Test
    public void testThatUserCanRegister() {
        createAccountRequest.setRole(Role.BORROWER);
        CreateAccountResponse response = authenticationService.Register(createAccountRequest);
        assertNotNull(response);
    }
    @Test
    public void testThatUserCanLogin() {
        createAccountRequest.setRole(Role.BORROWER);
        CreateAccountResponse response = authenticationService.Register(createAccountRequest);
        assertNotNull(response);
        assertEquals("Fabulous", createAccountRequest.getLastName());
        assertEquals("Iam", createAccountRequest.getFirstName());

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(loginRequest.getUsername());
        loginRequest.setPassword(loginRequest.getPassword());
        boolean loginResponse = authenticationService.login(loginRequest);
        assertTrue(loginResponse);
    }
    @Test
    public void testThatUserCanLogout() {
        createAccountRequest.setRole(Role.BORROWER);
        CreateAccountResponse response = authenticationService.Register(createAccountRequest);
        assertNotNull(response);
        assertEquals("Fabulous", createAccountRequest.getLastName());
        assertEquals("Iam", createAccountRequest.getFirstName());

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(loginRequest.getUsername());
        loginRequest.setPassword(loginRequest.getPassword());
        boolean loginResponse = authenticationService.login(loginRequest);
        assertTrue(loginResponse);
        boolean logoutResponse = authenticationService.logout();
        assertTrue(logoutResponse);
    }


}