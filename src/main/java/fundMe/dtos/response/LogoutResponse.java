package fundMe.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogoutResponse {
    private boolean isLoggedIn;
    private String message;
}
