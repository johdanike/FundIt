package fundMe.services;

import fundMe.data.models.User;
import fundMe.data.repositories.UserRepo;
import fundMe.dtos.request.CreateUserRequest;
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

            UserRepo userRepo = this.userRepo;
            User existingUser = userRepo.findByUsername(userRequest.getUsername());
            if (existingUser != null) {
                existingUser.setPassword(userRequest.getPassword());
                existingUser.setEmail(userRequest.getEmail());
                existingUser.setFirstName(userRequest.getFirstName());
                existingUser.setLastName(userRequest.getLastName());
                existingUser.setRole(userRequest.getRole());
                existingUser.setNIN(userRequest.getNIN());
                existingUser.setLoggedIn(userRequest.isLoggedIn());

                try{
                    User updatedUser = userRepo.save(existingUser);
                    return getCreateUpdateResponse(updatedUser);
                }catch (Exception e){
                    throw new RuntimeException("Error while updating user", e);
                }
            }
        else throw new IllegalArgumentException("Not updated successfully");

    }

    private static void UsernameUpdateUserRequestValidator(UpdateUserRequest userRequest) {
        if(userRequest == null || userRequest.getUsername() == null){
            throw new IllegalArgumentException("Username cannot be null");
        }
    }

    private static CreateUpdateResponse getCreateUpdateResponse(User savedUser) {
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

    @Override
    public void deleteUser(String id) {

    }

}

//private static User getUser(UpdateUserRequest updateUserRequest) {
//        if (updateUserRequest == null) {
//            throw new IllegalArgumentException("Fill in all details correctly");
//        }
//        User newUser = new User();
//        newUser.setUsername(updateUserRequest.getUsername());
//        newUser.setPassword(updateUserRequest.getPassword());
//        newUser.setEmail(updateUserRequest.getEmail());
//        newUser.setFirstName(updateUserRequest.getFirstName());
//        newUser.setLastName(updateUserRequest.getLastName());
//        newUser.setRole(updateUserRequest.getRole());
//        newUser.setNIN(updateUserRequest.getNIN());
//        newUser.setLoggedIn(updateUserRequest.isLoggedIn());
//
//        return newUser;
//    }




