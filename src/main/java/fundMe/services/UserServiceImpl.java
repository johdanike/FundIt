package fundMe.services;

import fundMe.Exceptions.UserNotFoundException;
import fundMe.data.models.User;
import fundMe.data.repositories.UserRepo;
import fundMe.dtos.request.CreateUserRequest;
import fundMe.dtos.request.DeleteUserRequest;
import fundMe.dtos.request.UpdateUserRequest;
import fundMe.dtos.response.CreateUpdateResponse;
import fundMe.dtos.response.CreateUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public CreateUserResponse createUser(CreateUserRequest user) {
        CreateUserResponse response = new CreateUserResponse();
        UsernameCreateUserRequestValidator(user);

            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());
            newUser.setEmail(user.getEmail());
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            newUser.setRole(user.getRole());
            newUser.setNIN(user.getNIN());
            newUser.setLoggedIn(user.isLoggedIn());

            try{
                User savedUser = userRepo.save(newUser);
                response.setMessage("Created Successfully !!!!");
            }catch (Exception e){
                response.setMessage("Invalid input: "+e.getMessage());
            }

            return response;
    }

    private static void UsernameCreateUserRequestValidator(CreateUserRequest userRequest) {
        if(userRequest == null || userRequest.getUsername() == null){
            throw new IllegalArgumentException("Username cannot be null");
        }
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }

    private User getExistingUser(){
        CreateUserRequest userRequest = new CreateUserRequest();
        return userRepo.findByUsername(userRequest.getUsername());
    }

    @Override
    public User findUserById(String id) {
        return getExistingUser();
    }

    @Override
    public CreateUpdateResponse updateUser(UpdateUserRequest userRequest) {
        UsernameUpdateUserRequestValidator(userRequest);

        User existingUser = userRepo.findByUsername(userRequest.getUsername());

        if (existingUser != null) {
            existingUser.setPassword(userRequest.getPassword());
            existingUser.setEmail(userRequest.getEmail());
            existingUser.setFirstName(userRequest.getFirstName());
            existingUser.setLastName(userRequest.getLastName());
            existingUser.setRole(userRequest.getRole());
            existingUser.setNIN(userRequest.getNIN());
            existingUser.setLoggedIn(userRequest.isLoggedIn());

            try {
                User updatedUser = userRepo.save(existingUser);
                return getCreateUpdateResponse(updatedUser);

            } catch (Exception e) {
                throw new RuntimeException("Error while updating user: " + e.getMessage(), e);
            }

        } else {
            throw new UserNotFoundException("User with username " + userRequest.getUsername() + " not found");
        }
    }

    private static void UsernameUpdateUserRequestValidator(UpdateUserRequest userRequest) {
        if (userRequest == null) {
            throw new IllegalArgumentException("User request cannot be null");
        }
        if (userRequest.getUsername() == null || userRequest.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (userRequest.getPassword() == null || userRequest.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        if (userRequest.getEmail() == null || userRequest.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
    }

    private CreateUpdateResponse getCreateUpdateResponse(User savedUser) {
        CreateUpdateResponse response = new CreateUpdateResponse();
        response.setMessage("Updated Successfully !!!!");
        response.setUsername(savedUser.getUsername());
        response.setLocalDateTime(savedUser.getCreatedAt());
        response.setLastName(savedUser.getLastName());
        response.setRole(savedUser.getRole());
        response.setEmail(savedUser.getEmail());
        response.setFirstName(savedUser.getFirstName());
        return response;
    }


    private static void ValidateUsernameAndPassword(DeleteUserRequest userRequest) {
        if (userRequest == null || userRequest.getUsername() == null){
            throw new IllegalArgumentException("Username cannot be null");
        }
    }

    @Override
    public void deleteUser(User user) {
        userRepo.delete(user);
    }

    @Override
    public void deleteById(String id){
//        for(User user : userRepo.findAll()){
            if(userRepo.existsById(id)){
//                userRepo.delete(user);
                userRepo.deleteById(id);
            }
//        }
        throw new IllegalArgumentException("User not found");
    }

    @Override
    public void deleteAllById(String username, String password){
        ValidateUsernameAndPassword(new DeleteUserRequest(username, password));
        for(User user: userRepo.findAll()){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                userRepo.delete(user);
            }
        }
    }

    @Override
    public void deleteAll(){
        userRepo.deleteAll();
    }

    @Override
    public User findById(String id) {
        for (User user : userRepo.findAll()) {
            ValidateUsernameAndPassword(new DeleteUserRequest(user.getUsername(), user.getPassword()));
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean existsById(String id) {
        return userRepo.existsById(id);
    }


}




