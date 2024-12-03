package fundMe.services;

import fundMe.data.models.Role;
import fundMe.dtos.request.CreateAccountRequest;
import fundMe.dtos.response.CreateAccountResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AuthenticationServiceImplTest {
    @Autowired
    private AuthenticationService authenticationService;
//
//    @BeforeEach
//    void startAllTestsWith() {
//        authenticationServiceImpl = new AuthenticationServiceImpl();
//    }

    @Test
    void testThatUserCanRegister() {
//        assertEquals(0, authenticationServiceImpl.count());
        CreateAccountRequest request = new CreateAccountRequest();
        request.setFirstName("Iam");
        request.setLastName("Fabulous");
        request.setPassword("password");
        request.setNIN("123456789");
        request.setEmail("test@test.com");
        request.setRole(Role.BORROWER);
        CreateAccountResponse response = authenticationService.Register(request);
        assertNotNull(response);


//        //assertTrue(authenticationServiceImpl.isRegistered());
//        assertEquals(1, authenticationServiceImpl.count());

    }

}