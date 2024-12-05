package fundMe.controllers;

import fundMe.dtos.request.CreateAccountRequest;
import fundMe.dtos.response.AccountApiResponse;
import fundMe.dtos.response.CreateAccountResponse;
import fundMe.dtos.response.UserApiResponse;
import fundMe.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/authentication")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

//    @PostMapping("/createAccount")
//    public ResponseEntity<?> register(@RequestBody CreateAccountRequest createAccountRequest) {
//        try {
//            CreateAccountResponse createAccountResponse = authenticationService.Register(createAccountRequest);
////            return new ResponseEntity<>(new UserApiResponse(true, createAccountRequest));
////            return ResponseEntity.ok(createAccountResponse);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

}
