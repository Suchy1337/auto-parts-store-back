package pl.suchan.apstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.suchan.apstore.DTOs.UserDTO;
import pl.suchan.apstore.enums.Role;
import pl.suchan.apstore.exceptions.UserRegistrationException;
import pl.suchan.apstore.models.User;
import pl.suchan.apstore.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addNewUser(UserDTO userDTO) throws UserRegistrationException {
        if(!checkIfUserExists(userDTO)){
            User convertedUser = convertToDao(userDTO);
            convertedUser.setRole(Role.USER);
            userRepository.save(convertedUser);
        }
        else{
            throw new UserRegistrationException("User already exists!");
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
