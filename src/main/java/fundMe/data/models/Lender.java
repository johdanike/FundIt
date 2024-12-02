package fundMe.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Lender {
    @DBRef
    @Id
    private String id;
    @DBRef
    private String name;
    private String password;
    @DBRef
    private double interestRate;
    @DBRef
    private String paymentPlan;
    @DBRef
    private String email;
    @DBRef
    private boolean isSent;
    @DBRef
    private boolean isReturned;
    List<String>Lender;
    List<String>lenderReceipt;
    @DBRef
    private Role role;
}
