package fundMe.services;

import fundMe.data.models.User;
import fundMe.dtos.request.CreateUserRequest;
import fundMe.dtos.request.UpdateUserRequest;
import fundMe.dtos.response.CreateUpdateResponse;
import fundMe.dtos.response.CreateUserResponse;
import org.springframework.stereotype.Service;


public interface UserService {
    CreateUserResponse createUser(CreateUserRequest user);
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    User findUserById(String id);
    CreateUpdateResponse updateUser(UpdateUserRequest user);
    void deleteUser(User user);
    void deleteById(String id);
    void deleteAllById(String username, String password);
    void deleteAll();
    User findById(String id);
    boolean existsById(String id);
}
