package fundMe.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoanResponse {
    private String loanId;
    private String message;
    private String lenderId;
    private String borrowerId;
}
