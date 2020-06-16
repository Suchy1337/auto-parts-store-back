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

    @PostMapping("/createUser")
    @ResponseBody
    public User createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping("/getUserById")
    @ResponseBody
    public User getUser(@RequestParam Long id){
        return userService.findUserById(id);
    }

    @GetMapping("/getUserByUsername")
    @ResponseBody
    public User getUser(@RequestParam String username){
        return userService.findUserByUsername(username);
    }
}
