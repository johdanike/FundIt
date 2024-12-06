package fundMe.controllers;

import fundMe.dtos.request.CreateAccountRequest;
import fundMe.dtos.request.LoginRequest;
import fundMe.dtos.response.AccountApiResponse;
import fundMe.dtos.response.CreateAccountResponse;
import fundMe.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/authentication")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/createAccount")
    public ResponseEntity<?> register(@RequestBody CreateAccountRequest createAccountRequest) {
        try {
            CreateAccountResponse createAccountResponse = authenticationService.Register(createAccountRequest);
            return new ResponseEntity<>(new AccountApiResponse(true, createAccountRequest), HttpStatus.CREATED);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            boolean createUserResponse = authenticationService.login(loginRequest);
            return new ResponseEntity<>(new AccountApiResponse(createUserResponse, loginRequest), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody LoginRequest loginRequest) {
        try {
            boolean createUserResponse = authenticationService.logout();
            return new ResponseEntity<>(new AccountApiResponse(createUserResponse, loginRequest), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
