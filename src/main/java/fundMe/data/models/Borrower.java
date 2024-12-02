package fundMe.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Borrower {
    @DBRef
    @Id
    private String id;
    @DBRef
    private String name;
    @DBRef
    private String password;
    @DBRef
    private double interestRate;
    @DBRef
    private String paymentPlan;
    @DBRef
    private String email;
    @DBRef
    private boolean isReceived;
    @DBRef
    private boolean isReturned;
    List<String> asset;
    List<String>borrowerReceipt;
    @DBRef
    private Role role;
}
