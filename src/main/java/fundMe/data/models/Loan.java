package fundMe.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Loan {
    @Id
    private String loanID;
    private String borrowerId;
    private String lenderId;
    private Double amount;
    private Double interestRate;
    private String paymentPlan;
    private Boolean isCollected;
    private Boolean isPaid;
    private LocalDateTime dateTime;
}
