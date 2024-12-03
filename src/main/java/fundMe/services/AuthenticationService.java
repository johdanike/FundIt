package fundMe.services;

public interface AuthenticationService {
    public String Login(String username, String password);
    public String Logout();
    public String Register(String firstName, String lastName, String username, String password);
}
