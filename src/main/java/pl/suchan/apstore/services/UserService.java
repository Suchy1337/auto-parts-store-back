package pl.suchan.apstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.suchan.apstore.DTOs.UserDTO;
import pl.suchan.apstore.enums.Role;
import pl.suchan.apstore.models.User;
import pl.suchan.apstore.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(){}

    public User createUser(UserDTO userDTO){
        if(!checkIfUserExists(userDTO)){
            User convertedUser = convertToDao(userDTO);
            convertedUser.setRole(Role.USER);
            return userRepository.save(convertedUser);
        }
        return null;
    }

    public User findUserById(long id){
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.orElse(null);
    }

    public User findUserByUsername(String username){
        Optional<User> foundUser = userRepository.findByUsername(username);
        return foundUser.orElse(null);
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
