package fundMe.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDateTime;

@Data
@Document
public class Loan {
    @Id
    private String loanID;
    private String borrowerId;
    private String lenderId;
    private Double amount;
    private Double interestRate;
    private PaymentPlan paymentPlan;
    private Boolean isCollected;
    private Boolean isPaid;
    private LocalDateTime dateTime;
}
