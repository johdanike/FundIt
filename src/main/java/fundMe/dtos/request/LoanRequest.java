package fundMe.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanRequest {
    private int loanId;
    private int userId;
    private int loanAmount;
}
