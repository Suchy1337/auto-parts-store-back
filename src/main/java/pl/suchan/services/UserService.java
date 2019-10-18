package pl.suchan.services;

import org.springframework.beans.factory.annotation.Autowired;
import pl.suchan.DTOs.UserDTO;
import pl.suchan.models.User;
import pl.suchan.repositories.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addNewUser(UserDTO userDTO){
        if(!checkIfUserExists(userDTO)){

        }
    }

    private boolean checkIfUserExists(UserDTO userDTO){
        return false;
    }

    private User convertToDao(UserDTO userDTO){
        return null;
    }


}
