package fundMe.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Loan {
    @Id
    @DBRef
    private int loanID;
    @DBRef
    private String borrowerId;
    @DBRef
    private String lenderId;
    @DBRef
    private Long amount;
    @DBRef
    private int interestRate;
    @DBRef
    private String paymentPlan;
    @DBRef
    private Boolean isCollected;
    @DBRef
    private Boolean isPaid;
    @DBRef
    private LocalDateTime dateTime;
//    @DBRef
//    private List<String>lender = new ArrayList<>();
//    private List<String>borrower = new ArrayList<>();
}
