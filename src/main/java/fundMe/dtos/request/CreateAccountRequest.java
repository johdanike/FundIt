package fundMe.dtos.request;

import fundMe.data.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CreateAccountRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Role role;
    private String NIN;
    private LocalDateTime createdAt;
}
