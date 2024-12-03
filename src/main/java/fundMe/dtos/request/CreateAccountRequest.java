package fundMe.dtos.request;

import fundMe.data.models.Role;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateAccountRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    private String NIN;

}
