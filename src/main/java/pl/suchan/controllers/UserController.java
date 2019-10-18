package pl.suchan.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.suchan.DTOs.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.suchan.exceptions.UserException;
import pl.suchan.services.UserService;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/createUser")
    @ResponseBody
    public ResponseEntity<String> addNewUser(@RequestBody UserDTO userDTO) {
        try{
            userService.addNewUser(userDTO);
            return new ResponseEntity<>("User created", HttpStatus.CREATED);
        }
        catch(UserException userException){
            return new ResponseEntity<>(userException.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
