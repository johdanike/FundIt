package fundMe.services;

import fundMe.data.models.Role;
import fundMe.data.models.User;
import fundMe.data.repositories.UserRepository;
import fundMe.dtos.request.CreateUserRequest;
import fundMe.dtos.request.UpdateUserRequest;
import fundMe.dtos.response.CreateUpdateResponse;
import fundMe.dtos.response.CreateUserResponse;
import fundMe.dtos.response.DeleteUserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService userService;
    @Autowired
    private UserRepository userRepository;
    private CreateUserRequest request;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();

        request = new CreateUserRequest();
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setUsername("test");
        request.setRole(Role.BORROWER);
        request.setPassword("test");
        request.setEmail("test@test.com");
        request.setNIN("123456789");
    }


    @Test
    public void test_thatUserCanBeAdded() {
        CreateUserResponse response = userService.createUser(request);
        assertNotNull(response);

    }
    @Test
    public void test_thatUserCanBeUpdated() {
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
        userRepository.save(existingUser);
        CreateUpdateResponse updateResponse = userService.updateUser(updateUserRequest);
        assertNotNull(updateResponse);
        assertEquals("Updated Successfully !!!!", updateResponse.getMessage());
        assertEquals("Dan", updateResponse.getFirstName());
    }
    @Test
    public void test_thatUserCanBeDeletedById() {
        request = new CreateUserRequest();
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setUsername("test");
        request.setRole(Role.BORROWER);
        request.setPassword("test");
        request.setEmail("test@test.com");
        request.setNIN("123456789");
        CreateUserResponse response = userService.createUser(request);
        System.out.println(response);

        DeleteUserResponse deleteUserResponse = userService.deleteById(response.getId());
        assertThat(deleteUserResponse.getId()).isNull();
    }
    @Test
    public void test_thatUserCanBeFoundByEmail(){
        CreateUserResponse response = userService.createUser(request);
        assertNotNull(response);
        userService.findUserByEmail(response.getEmail());
        assertEquals(response.getEmail(), "test@test.com");

    }
    @Test
    public void test_thatUserCanBeFound_byUsername(){
        CreateUserResponse response = userService.createUser(request);
        assertNotNull(response);
        userService.findUserByUsername(response.getUsername());
        assertEquals("test", response.getUsername());
    }
    @Test
    public void test_thatUserCanBeFoundById(){
        CreateUserResponse response = userService.createUser(request);
        assertNotNull(response);
        userService.findById(response.getId());
        assertEquals("test", response.getUsername());
    }
    @Test
    public void test_thatAllUsersCanBeDeleted() {
        CreateUserResponse response = userService.createUser(request);
        assertNotNull(response);
        DeleteUserResponse deleteUserResponse = userService.deleteAll();
        assertThat(deleteUserResponse).isNull();
    }
    @Test
    public void test_thatAllUsersCanBeFound() {
        CreateUserResponse response = userService.createUser(request);
        assertNotNull(response);
        userService.findAllUsers(response.getId());
        assertThat(response).isNotNull();
    }
    @Test
    public void test_thatUserExists(){
        CreateUserResponse response = userService.createUser(request);
        assertNotNull(response);
        String userId  = response.getId();
        boolean userExists =  userService.existsById(userId);
        assertTrue(userExists);
    }



}