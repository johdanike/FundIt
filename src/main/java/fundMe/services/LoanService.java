package fundMe.services;

import fundMe.dtos.request.LoanRequest;
import fundMe.dtos.response.LoanResponse;

public interface LoanService{
    LoanResponse getLoan(LoanRequest loan);
}
