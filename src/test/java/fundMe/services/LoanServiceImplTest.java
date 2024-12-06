package fundMe.services;

import fundMe.data.models.PaymentPlan;
import fundMe.data.repositories.LoanRepository;
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
    @Autowired
    private LoanRepository loanRepository;

    @BeforeEach
    public void setUp() {

        loanRequest = new LoanRequest();
        loanRequest.setLoanAmount(500_000.00);
        loanRequest.setDateTime(LocalDateTime.now());
        loanRequest.setIsPaid(false);
        loanRequest.setIsCollected(false);
        loanRequest.setInterestRate(0.05);

    }

    @Test
    public void test_thatUserCanAddLoan(){
        loanRequest.setPaymentPlan(String.valueOf(PaymentPlan.INSTALLMENT_PAY));
        LoanResponse loanResponse = loanService.getLoan(loanRequest);
        assertNotNull(loanResponse);
    }
    @Test
    public void test_thatUserCanAddLoan_forOneOffPaymentPlan(){
        loanRequest.setPaymentPlan(String.valueOf(PaymentPlan.ONE_OFF_PAY));
        LoanResponse loanResponse = loanService.getLoan(loanRequest);
        assertNotNull(loanResponse);
    }
}