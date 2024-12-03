package fundMe.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    @Id
    @DBRef
    private int id;
    @DBRef
    private String firstName;
    @DBRef
    private String lastName;
    @DBRef
    private String email;
    @DBRef
    private String password;
    @DBRef
    private String NIN;
    @DBRef
    private Role role;
    private boolean isRegistered = false;
}
