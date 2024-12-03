package fundMe.services;

import fundMe.data.models.Loan;
import fundMe.data.models.Role;
import fundMe.data.models.User;

public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public String Login(String username, String password) {
        return "";
    }

    @Override
    public String Logout() {
        return "";
    }

    @Override
    public String Register(String firstName, String lastName, Role role, String password) {
        if(role.equals(Role.BORROWER)){
            Loan loan = new Loan();
        }
        return "";
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public boolean isRegistered() {
        User user = new User();
        return user.isRegistered();
    }
}
