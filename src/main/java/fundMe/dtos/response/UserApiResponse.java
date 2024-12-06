package fundMe.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserApiResponse {
   private boolean isSuccess;
   private Object CreateUserResponse;
}
