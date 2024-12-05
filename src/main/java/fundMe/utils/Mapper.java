package fundMe.utils;

import fundMe.data.models.Loan;
import fundMe.dtos.request.LoanRequest;

public class Mapper {

    public static Loan Map(LoanRequest loanRequest) {
        Loan loan = new Loan();
        loan.setAmount((long) loanRequest.getLoanAmount());
        loan.setDateTime(loanRequest.getDateTime());
        loan.setInterestRate(loanRequest.getInterestRate());
        loan.setIsCollected(loanRequest.isCollected());
        loan.setIsPaid(loanRequest.getDateTime().isEqual(loan.getDateTime()));
        loan.setPaymentPlan(loanRequest.getPaymentPlan());

        return loan;
    }
}
