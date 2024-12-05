package fundMe.Exceptions;

public class UserNameFieldCannotBeEmptyException extends RuntimeException {
    public UserNameFieldCannotBeEmptyException(String username) {
        super(username);
    }
}
