package fundMe.dtos.response;

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
public class CreateUpdateResponse {
    private String firstName;
    private String lastName;
    private String email;
//    private String password;
    private String username;
    private Role role;
//    private String NIN;
    private LocalDateTime localDateTime;
    private String message;
}
