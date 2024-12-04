package fundMe.services;

import fundMe.data.models.Role;
import fundMe.data.models.User;
import fundMe.data.repositories.UserRepo;
import fundMe.dtos.request.CreateUserRequest;
import fundMe.dtos.request.DeleteUserRequest;
import fundMe.dtos.request.UpdateUserRequest;
import fundMe.dtos.response.CreateUpdateResponse;
import fundMe.dtos.response.CreateUserResponse;
import fundMe.dtos.response.DeleteUserResponse;
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
    public void test_ThatUserCanBeAdded() {
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
    public void test_ThatUserCanBeUpdated() {
        CreateUserRequest request = new CreateUserRequest();
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
        updateUserRequest.setUsername("testuser");
        updateUserRequest.setPassword("newpassword");
        updateUserRequest.setEmail("test@test.com");
        updateUserRequest.setFirstName("Dan");
        updateUserRequest.setLastName("Han");
        updateUserRequest.setRole(Role.LENDER);
        updateUserRequest.setNIN(request.getNIN());
        updateUserRequest.setLoggedIn(true);

        User existingUser = new User();
        existingUser.setUsername("testuser");
        userRepo.save(existingUser);
        CreateUpdateResponse updateResponse = userService.updateUser(updateUserRequest);

        assertNotNull(updateResponse);
        assertEquals("Updated Successfully !!!!", updateResponse.getMessage());
        assertEquals("Dan", updateResponse.getFirstName());
    }
    @Test
    public void test_ThatUserCanBeDeleted() {
        CreateUserRequest request = new CreateUserRequest();
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setUsername("test");
        request.setRole(Role.BORROWER);
        request.setPassword("test");
        request.setEmail("test@test.com");
        request.setNIN("123456789");
        CreateUserResponse response = userService.createUser(request);
        assertNotNull(response);

        User createdUser = userRepo.findByUsername("test");
        assertNotNull(createdUser);
        assertEquals(createdUser.getUsername(), request.getUsername());
        userRepo.deleteById(createdUser.getId());
        assertFalse(userRepo.existsById(request.getUsername()));




    }
}