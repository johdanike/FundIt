package fundMe.services;

import fundMe.data.models.User;

public class UserServiceImpl implements UserService {
    @Override
    public String createUser(User user) {
        if(user.isRegistered() && user.isLoggedIn()){
            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());
            newUser.setEmail(user.getEmail());
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            newUser.setRole(user.getRole());
            newUser.setNIN(user.getNIN());
            newUser.setLoggedIn();
        }
        return "";
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }

    @Override
    public User findUserById(String id) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(String id) {

    }
}
