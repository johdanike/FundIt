package fundMe.services;

import fundMe.data.models.Role;
import fundMe.data.models.User;
import fundMe.data.repositories.UserRepo;
import fundMe.dtos.request.CreateAccountRequest;
import fundMe.dtos.response.CreateAccountResponse;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {


    private final UserRepo userRepo;
    private int counter = 0;

    public AuthenticationServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public String Login(String username, String password) {
        return "";
    }

    @Override
    public String Logout() {
        return "";
    }

    @Override
    public CreateAccountResponse Register(CreateAccountRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setNIN(request.getNIN());
        userRepo.save(user);
        CreateAccountResponse response = new CreateAccountResponse();
        response.setMessage("Successfully Registered!");
        return response;
    }


    public int count() {
        return counter++;
    }
}
