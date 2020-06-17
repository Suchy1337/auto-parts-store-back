package pl.suchan.apstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.suchan.apstore.DTOs.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import pl.suchan.apstore.models.User;
import pl.suchan.apstore.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/createUser")
    public User createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @ResponseBody
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @ResponseBody
    @GetMapping("/getUserByUsername/{username}")
    public User getUser(@PathVariable String username){
        return userService.findUserByUsername(username);
    }
}
