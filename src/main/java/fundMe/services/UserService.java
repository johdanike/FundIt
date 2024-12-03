package fundMe.services;

import fundMe.data.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String createUser(User user);
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    User findUserById(String id);
    void updateUser(User user);
    void deleteUser(String id);

}
