package fundMe.services;

import fundMe.data.models.Role;
import fundMe.dtos.request.CreateAccountRequest;
import fundMe.dtos.response.CreateAccountResponse;

public interface AuthenticationService {
    public String Login(String username, String password);
    public String Logout();
    public CreateAccountResponse Register(CreateAccountRequest request);
}
