package fundMe.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String NIN;
    private Role role;
    private LocalDateTime createdAt;
    private boolean isRegistered;
    private boolean isLoggedIn;
}
