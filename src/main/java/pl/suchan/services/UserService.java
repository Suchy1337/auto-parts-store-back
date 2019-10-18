package pl.suchan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.suchan.DTOs.UserDTO;
import pl.suchan.exceptions.UserException;
import pl.suchan.models.User;
import pl.suchan.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addNewUser(UserDTO userDTO) throws UserException {
        if(!checkIfUserExists(userDTO)){
            userRepository.save(convertToDao(userDTO));
        }
        else{
            throw new UserException("User already exists!");
        }
    }

    private boolean checkIfUserExists(UserDTO userDTO){
        return userRepository.findByUsername(userDTO.getUsername()).isPresent();
    }

    private User convertToDao(UserDTO userDTO){
        User createdUser = new User();
        createdUser.setMailAddress(userDTO.getMailAddress());
        createdUser.setPassword(hashPassword(userDTO.getPassword()));
        createdUser.setUsername(userDTO.getUsername());
        return createdUser;
    }

    private String hashPassword(String password){
        return password;
    }
}
