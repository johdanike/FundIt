package fundMe.services;

import fundMe.dtos.request.CreateAccountRequest;
import fundMe.dtos.request.LoginRequest;
import fundMe.dtos.response.CreateAccountResponse;

public interface AuthenticationService {
    CreateAccountResponse Register(CreateAccountRequest request);
    boolean login(LoginRequest loginRequest);
    boolean logout();
}
