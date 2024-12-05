package fundMe.controllers;

import fundMe.Exceptions.UserNotFoundException;
import fundMe.data.models.User;
import fundMe.dtos.request.CreateUserRequest;
import fundMe.dtos.request.UpdateUserRequest;
import fundMe.dtos.response.UserApiResponse;
import fundMe.dtos.response.CreateUpdateResponse;
import fundMe.dtos.response.CreateUserResponse;
import fundMe.dtos.response.DeleteUserResponse;
import fundMe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest createUserRequest) {
        try{
            CreateUserResponse createUserResponse = userService.createUser(createUserRequest);
            return new ResponseEntity<>(new UserApiResponse(true, createUserResponse), HttpStatus.CREATED);

        }catch (UserNotFoundException e){
            return new ResponseEntity<>(new UserApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/updateUser")
    public ResponseEntity<?> updateUser( @RequestBody UpdateUserRequest updateUserRequest) {
        try {
            CreateUpdateResponse updateResponse = userService.updateUser(updateUserRequest);
            return new ResponseEntity<>(new UserApiResponse(true, updateResponse), HttpStatus.OK);
        } catch (UserNotFoundException e){
            return new ResponseEntity<>(new UserApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findUserByEmail")
    public  ResponseEntity<?> findUserByEmail(@RequestParam("email") String email) {
        try {
            User user = userService.findUserByEmail(email);
            return new ResponseEntity<>(new UserApiResponse(true, user), HttpStatus.OK);
        }catch (UserNotFoundException e){
            return new ResponseEntity<>(new UserApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findUserByUsername")
    public ResponseEntity<?> findUserByUsername(@RequestParam("username") String username) {
        try {
            Optional<User> user = userService.findUserByUsername(username);
            return new ResponseEntity<>(new UserApiResponse(true, user), HttpStatus.OK);
        } catch (UserNotFoundException e){
            return new ResponseEntity<>(new UserApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<?> deleteById(@RequestParam("id") String id) {
        try {
            DeleteUserResponse deleteUserResponse = userService.deleteById(id);
            return new ResponseEntity<>(new UserApiResponse(true, deleteUserResponse), HttpStatus.OK);
        } catch (UserNotFoundException e){
            return new ResponseEntity<>(new UserApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAllUsers")
    public ResponseEntity<?> deleteAll(){
        try {
            userService.deleteAll();
            return new ResponseEntity<>(new UserApiResponse(true, userService.deleteAll()), HttpStatus.OK);
        } catch (UserNotFoundException e){
            return new ResponseEntity<>(new UserApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam("id") String id) {
        try {
            User user = userService.findById(id);
            return new ResponseEntity<>(new UserApiResponse(true, user), HttpStatus.OK);
        } catch (UserNotFoundException e){
            return new ResponseEntity<>(new UserApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/existsById")
    public ResponseEntity<?> existsById(@RequestParam("id") String id) {
        try {
            boolean user = userService.existsById(id);
            return new ResponseEntity<>(new UserApiResponse(true, user), HttpStatus.OK);
        } catch (UserNotFoundException e){
            return new ResponseEntity<>(new UserApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAllUsers")
    public ResponseEntity<?> findAllUsers(@RequestParam("id") String id){
        try {
            List<User> users = userService.findAllUsers(id);
            return new ResponseEntity<>(new UserApiResponse(true, users), HttpStatus.OK);
        } catch (UserNotFoundException e){
            return new ResponseEntity<>(new UserApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }



}
