package fundMe.dtos.request;

import fundMe.data.models.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticateRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String NIN;
    private Role role;
}
