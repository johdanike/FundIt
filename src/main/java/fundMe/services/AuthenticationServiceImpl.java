package fundMe.services;

import fundMe.Exceptions.UserNotFoundException;
import fundMe.data.models.User;
import fundMe.data.repositories.UserRepository;
import fundMe.dtos.request.CreateAccountRequest;
import fundMe.dtos.request.LoginRequest;
import fundMe.dtos.response.CreateAccountResponse;
import org.springframework.stereotype.Service;

import static java.time.format.DateTimeFormatter.ofLocalizedDateTime;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateAccountResponse Register(CreateAccountRequest request) {
        checkIfUserExists(request.getUsername());
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setNIN(request.getNIN());
        user.setRole(request.getRole());
        user.setLoggedIn(false);
        user.setRegistered(true);
        user.setCreatedAt(request.getLocalDateTime());
        userRepository.save(user);
        CreateAccountResponse response = new CreateAccountResponse();
        response.setMessage("Successfully Registered!");
        return response;
    }

    private void checkIfUserExists(String username) {
        if(userRepository.findByUsername(username) != null)
            throw new UserNotFoundException("Username " + username + " already exists!");
    }

    private User getCurrentUser() {
        User user = new User();
        if(userRepository.findByUsername(user.getUsername()) != null || user.isLoggedIn()) {
            return userRepository.findByUsername(user.getUsername());
        }
        return user;
//        return user.isLoggedIn() ? user : null;
    }

    @Override
    public boolean login(LoginRequest loginRequest) {
        User user = this.userRepository.findByUsername(loginRequest.getUsername());
        if (user == null && loginRequest.getUsername()==null && loginRequest.getPassword()==null) {
            throw new IllegalArgumentException("Invalid username or password!");
        }
        assert user != null;
        user.setLoggedIn(true);
        System.out.println("Logged In Successfully");
        return user.isLoggedIn();
    }

    @Override
    public boolean logout() {
        User user = getCurrentUser();
        user.setLoggedIn(false);
        userRepository.save(user);
        return true;
    }


}