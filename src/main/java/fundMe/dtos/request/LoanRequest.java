package fundMe.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LoanRequest {
    private String  loanId;
    private String userId;
    private Double loanAmount;
    private LocalDateTime dateTime;
    private Boolean isPaid;
    private Boolean isCollected;
    private String paymentPlan;
    private Double interestRate;
}
