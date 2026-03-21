package com.example.miniMarketPlace.users.domain;

import com.example.miniMarketPlace.users.domain.exceptions.UserNotFound;
import com.example.miniMarketPlace.users.domain.exceptions.UsernameAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        Optional<User> userSearch = userRepository.findByUsername(user.getUsername());
        if (userSearch.isPresent()) {
            throw new UsernameAlreadyExistsException("Username exists");
        }
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        Optional<User> userSearch = userRepository.findById(user.getId());
        if (userSearch.isPresent()) {
            User existing = userSearch.get();
            existing.setUsername(user.getUsername());
            existing.setEmail(user.getEmail());
            return userRepository.save(existing);
        }
        throw new UserNotFound("User not found");
    }

    public void deleteUser(User user) {
        Optional<User> userSearch = userRepository.findById(user.getId());
        if (!userSearch.isPresent()) {
            throw new UserNotFound("User not found");
        }
        userRepository.deleteById(user.getId());
    }


}
