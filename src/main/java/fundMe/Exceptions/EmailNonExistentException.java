package fundMe.Exceptions;

public class EmailNonExistentException extends RuntimeException {
    public EmailNonExistentException(String email) {
        super(email);
    }
}
