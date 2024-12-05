package fundMe.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LoanRequest {
    private int loanId;
    private int userId;
    private int loanAmount;
    private LocalDateTime dateTime;
    private boolean isPaid;
    private boolean isCollected;
    private String paymentPlan;
    private int interestRate;
}
