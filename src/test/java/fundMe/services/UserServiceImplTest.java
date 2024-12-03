package fundMe.services;

import fundMe.data.models.Role;
import fundMe.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    public void testThatUserCanBeAdded() {
        CreateUserRequest request =new CreateUserRequest();
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setUsername("test");
        request.setRole(Role.BORROWER);
        request.setPassword("test");
        request.setEmail("test@test.com");
        request.setNIN("123456789");

        CreateUserResponse response = userService.createUser(request);
        assertEquals("test",userService.getUsername());

    }
}