package fundMe.services;

import fundMe.data.models.Role;
import fundMe.data.models.User;
import fundMe.data.repositories.UserRepo;
import fundMe.dtos.request.CreateUserRequest;
import fundMe.dtos.request.UpdateUserRequest;
import fundMe.dtos.response.CreateUpdateResponse;
import fundMe.dtos.response.CreateUserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService userService;
    @Autowired
    private UserRepo userRepo;

    @BeforeEach
    public void setUp() {
        userRepo.deleteAll();
    }

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
        assertNotNull(response);

    }
    @Test
    public void testThatUserCanBeUpdated() {
        CreateUserRequest request =new CreateUserRequest();
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setUsername("test");
        request.setRole(Role.BORROWER);
        request.setPassword("test");
        request.setEmail("test@test.com");
        request.setNIN("123456789");
        CreateUserResponse response = userService.createUser(request);
        assertNotNull(response);

        UpdateUserRequest updateUserRequest = new UpdateUserRequest();
        updateUserRequest.setFirstName("Mary");
        updateUserRequest.setLastName("Doe");
        updateUserRequest.setUsername("test");
        updateUserRequest.setRole(Role.BORROWER);
        updateUserRequest.setPassword("test");
        updateUserRequest.setEmail("test@test.com");
        updateUserRequest.setNIN("123456789");
        CreateUpdateResponse updateUserResponse = userService.updateUser(updateUserRequest);

        assertEquals("Mary", updateUserResponse.getFirstName());
        assertEquals(updateUserRequest.getLastName(), updateUserResponse.getLastName());


    }
}