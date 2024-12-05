package fundMe.services;

import fundMe.data.models.Loan;
import fundMe.data.models.PaymentPlan;
import fundMe.data.repositories.LoanRepo;
import fundMe.dtos.request.LoanRequest;
import fundMe.dtos.response.LoanResponse;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepo loanRepo;

    public LoanServiceImpl(LoanRepo loanRepo) {
        this.loanRepo = loanRepo;
    }

    @Override
    public LoanResponse getLoan(LoanRequest loan) {

        Loan userLoan = new Loan();
        userLoan.setIsPaid(loan.getIsPaid());
        userLoan.setDateTime(loan.getDateTime());
        userLoan.setIsCollected(loan.getIsCollected());
        userLoan.setIsPaid(loan.getIsPaid());
        userLoan.setAmount(loan.getLoanAmount());
        userLoan.setPaymentPlan(PaymentPlan.valueOf(loan.getPaymentPlan()));
        userLoan.setInterestRate(loan.getInterestRate());
        userLoan.setLenderId(loan.getUserId());
        userLoan.setBorrowerId(loan.getUserId());
        userLoan.setLoanID(loan.getLoanId());
        userLoan.setIsPaid(loan.getIsPaid());
        userLoan.setIsCollected(loan.getIsCollected());
        loanRepo.save(userLoan);
        LoanResponse loanResponse = new LoanResponse();
        loanResponse.setMessage("Loan request successful");
        loanResponse.setLenderId(userLoan.getLenderId());
        loanResponse.setBorrowerId(userLoan.getBorrowerId());
        loanResponse.setLoanId(userLoan.getLoanID());
        return loanResponse;
    }
}
