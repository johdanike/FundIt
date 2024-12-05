package fundMe.services;

import fundMe.Exceptions.UserAlreadyExistException;
import fundMe.Exceptions.UserNameFieldCannotBeEmptyException;
import fundMe.Exceptions.UserNotFoundException;
import fundMe.data.models.User;
import fundMe.data.repositories.UserRepo;
import fundMe.dtos.request.CreateUserRequest;
import fundMe.dtos.request.DeleteUserRequest;
import fundMe.dtos.request.UpdateUserRequest;
import fundMe.dtos.response.CreateUpdateResponse;
import fundMe.dtos.response.CreateUserResponse;
import fundMe.dtos.response.DeleteUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public CreateUserResponse createUser(CreateUserRequest user) {
        UsernameCreateUserRequestValidator(user);

            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());
            newUser.setEmail(user.getEmail());
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            newUser.setRole(user.getRole());
            newUser.setNIN(user.getNIN());
            newUser.setLoggedIn(true);
            newUser.setRegistered(true);
            userRepo.save(newUser);

            CreateUserResponse response = new CreateUserResponse();
            response.setEmail(newUser.getEmail());
            response.setId(newUser.getId());
            response.setUsername(newUser.getUsername());
            response.setMessage("User created successful");
            return response;
    }



    private static void UsernameCreateUserRequestValidator(CreateUserRequest userRequest) {
        if(userRequest == null || userRequest.getUsername() == null){
            throw new UserNameFieldCannotBeEmptyException("Username cannot be null");
        }
    }


    @Override
    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(() -> new UserNotFoundException("user not found"));
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return Optional.of(user);
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
            throw new UserAlreadyExistException("User with username " + userRequest.getUsername() + " already exists!");
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
    public DeleteUserResponse deleteById(String id){
        User user =  userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("user not found"));
        userRepo.delete(user);
        DeleteUserResponse deleteUserResponse = new DeleteUserResponse();
        deleteUserResponse.setMessage("Deleted Successfully !!!!");
        deleteUserResponse.setId(user.getId());
        return deleteUserResponse;
    }


    @Override
    public DeleteUserResponse deleteAll(){
        userRepo.deleteAll();
        DeleteUserResponse response = new DeleteUserResponse();
        response.setMessage("Deleted Successfully !!!!");
        return response;
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

    @Override
    public List<User> findAllUsers(String id) {
        return userRepo.findAll();
    }


}




