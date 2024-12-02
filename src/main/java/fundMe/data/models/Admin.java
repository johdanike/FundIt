package fundMe.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Admin {
    @DBRef
    private String username;
    @DBRef
    private String password;
}
