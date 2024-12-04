package fundMe.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class DeleteUserRequest {
    private String username;
    private String password;
}
