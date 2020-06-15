package pl.suchan.apstore.controllers;

import org.springframework.web.bind.annotation.*;
import pl.suchan.apstore.DTOs.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import pl.suchan.apstore.models.User;
import pl.suchan.apstore.services.UserService;

@RestController("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public User createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public User getUser(@RequestBody UserDTO user){
        return userService.findUserById(user.getId());
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public User getUserByUsername(@RequestBody UserDTO user){
        return userService.findUserByUsername(user.getUsername());
    }
}
