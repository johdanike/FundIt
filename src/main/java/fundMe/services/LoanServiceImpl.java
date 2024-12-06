package fundMe.services;

import fundMe.Exceptions.UserNotFoundException;
import fundMe.data.models.Loan;
import fundMe.data.models.PaymentPlan;
import fundMe.data.repositories.LoanRepository;
import fundMe.data.repositories.UserRepository;
import fundMe.dtos.request.LoanRequest;
import fundMe.dtos.response.LoanResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;



    @Override
    public LoanResponse getLoan(LoanRequest loan) {
//        checkIfUserExists(loan.getUserId());

        Loan newLoanRequest = new Loan();
        newLoanRequest.setAmount(loan.getLoanAmount());
        newLoanRequest.setPaymentPlan(PaymentPlan.valueOf(loan.getPaymentPlan()));
        newLoanRequest.setIsPaid(loan.getIsPaid());
        newLoanRequest.setInterestRate(loan.getInterestRate());
        newLoanRequest.setIsCollected(loan.getIsCollected());
        newLoanRequest.setBorrowerId(loan.getUserId());
        newLoanRequest.setLenderId(loan.getLenderId());
        newLoanRequest.setDateTime(LocalDateTime.now());
        loanRepository.save(newLoanRequest);

        LoanResponse loanResponse = new LoanResponse();
        loanResponse.setMessage("Loan request successful");
        loanResponse.setLenderId(newLoanRequest.getLenderId());
        loanResponse.setBorrowerId(newLoanRequest.getBorrowerId());
        loanResponse.setLoanId(newLoanRequest.getLoanId());
        loanResponse.setUserId(newLoanRequest.getUserId());

        return loanResponse;
    }

    private void checkIfUserExists(String userId) {
        if(userId == null){
            throw new UserNotFoundException("user id field cannot be null or empty");
        }

        if (!userRepository.existsById(userId) || userId.isEmpty()) {
                throw new UserNotFoundException(userId);
        }

    }
}
