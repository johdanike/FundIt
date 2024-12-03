package fundMe.services;

import fundMe.data.models.Role;

public interface AuthenticationService {
    public String Login(String username, String password);
    public String Logout();
    public String Register(String firstName, String lastName, Role role, String password);
    int count();
    boolean isRegistered();
}
