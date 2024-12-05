package fundMe.dtos.request;

import fundMe.data.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;
    private Role role;
    private String NIN;
    private LocalDateTime localDateTime;
    public boolean isLoggedIn;

}
