package pl.suchan.apstore.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.suchan.apstore.DTOs.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.suchan.apstore.exceptions.UserRegistrationException;
import pl.suchan.apstore.services.UserService;

@RestController("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/registration")
    @ResponseBody
    public ResponseEntity<String> addNewUser(@RequestBody UserDTO userDTO) {
        try{
            userService.addNewUser(userDTO);
            return new ResponseEntity<>("User created", HttpStatus.CREATED);
        }
        catch(UserRegistrationException userRegistrationException){
            return new ResponseEntity<>(userRegistrationException.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
