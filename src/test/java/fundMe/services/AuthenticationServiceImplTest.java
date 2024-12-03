package fundMe.services;

import fundMe.data.models.Role;
import fundMe.data.repositories.UserRepo;
import fundMe.dtos.request.CreateAccountRequest;
import fundMe.dtos.request.LoginRequest;
import fundMe.dtos.response.CreateAccountResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class AuthenticationServiceImplTest {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    UserRepo userRepo;
    @BeforeEach
    void setUp() {

        userRepo.deleteAll();
    }


    @Test
    void testThatUserCanRegister() {
        CreateAccountRequest request = new CreateAccountRequest();
        request.setFirstName("Iam");
        request.setLastName("Fabulous");
        request.setUsername("iamFabulous");
        request.setPassword("123456");
        request.setPassword("password");
        request.setNIN("123456789");
        request.setEmail("test@test.com");
        request.setRole(Role.BORROWER);
        CreateAccountResponse response = authenticationService.Register(request);
        assertNotNull(response);

    }

    @Test
    void testThatUserCanLogin() {
        CreateAccountRequest request = new CreateAccountRequest();
        request.setFirstName("Iam");
        request.setLastName("Fabulous");
        request.setUsername("iamFabulous");
        request.setPassword("123456");
        request.setNIN("123456789");
        request.setEmail("test@test.com");
        request.setRole(Role.BORROWER);
        CreateAccountResponse response = authenticationService.Register(request);
        assertNotNull(response);
        assertEquals("Fabulous", request.getLastName());
        assertEquals("Iam", request.getFirstName());

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.getUsername();
        loginRequest.getPassword();
        boolean loginResponse = authenticationService.login(loginRequest);
        assertTrue( loginResponse);

    }

}