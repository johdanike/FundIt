package fundMe.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountApiResponse{
    boolean isSuccess;
    Object CreateAccountResponse;
}
