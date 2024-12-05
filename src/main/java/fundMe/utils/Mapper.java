package fundMe.utils;

import fundMe.data.models.Loan;
import fundMe.data.models.PaymentPlan;
import fundMe.dtos.request.LoanRequest;

public class Mapper {

    public static Loan map(LoanRequest loanRequest) {
        Loan loan = new Loan();
        loan.setAmount(loanRequest.getLoanAmount());
        loan.setDateTime(loanRequest.getDateTime());
        loan.setInterestRate(loanRequest.getInterestRate());
        loan.setIsCollected(loanRequest.getIsCollected());
        loan.setIsPaid(loanRequest.getDateTime().isEqual(loan.getDateTime()));
        loan.setPaymentPlan(PaymentPlan.valueOf(loanRequest.getPaymentPlan()));

        return loan;
    }
}
