package fundMe.services;

import fundMe.dtos.request.LoanRequest;
import fundMe.dtos.response.LoanResponse;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {

    @Override
    public LoanResponse getLoan(LoanRequest loan) {
        return null;
    }
}
