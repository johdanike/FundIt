package fundMe.controllers;

import fundMe.dtos.request.LoanRequest;
import fundMe.dtos.response.UserApiResponse;
import fundMe.dtos.response.LoanResponse;
import fundMe.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/v1/loan")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping("/createLoan")
    public ResponseEntity<?> getLoanService(LoanRequest loanRequest) {
        try{
            LoanResponse loanResponse = loanService.getLoan(loanRequest);
            return new ResponseEntity<>(new UserApiResponse(true, loanResponse), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new UserApiResponse(false, e.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }
}
