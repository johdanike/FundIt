package fundMe.services;

import fundMe.data.models.PaymentPlan;
import fundMe.data.repositories.LoanRepo;
import fundMe.dtos.request.LoanRequest;
import fundMe.dtos.response.LoanResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class LoanServiceImplTest {
    @Autowired
    private LoanServiceImpl loanService;
    private LoanRequest loanRequest;

    @BeforeEach
    public void setUp() {


        loanRequest = new LoanRequest();
        loanRequest.setLoanAmount(500_000.00);
        loanRequest.setDateTime(LocalDateTime.now());
        loanRequest.setIsPaid(false);
        loanRequest.setIsCollected(false);
        loanRequest.setInterestRate(0.05);
        loanRequest.setPaymentPlan(String.valueOf(PaymentPlan.INSTALLMENT_PAY));


    }

    @Test
    public void test_thatUserCanAddLoan(){;
        LoanResponse loanResponse = loanService.getLoan(loanRequest);
        assertNotNull(loanResponse);
    }
}