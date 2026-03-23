package com.example.miniMarketPlace.users.adapters.in;

import com.example.miniMarketPlace.users.domain.User;
import com.example.miniMarketPlace.users.domain.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public User findUserById(Long id) {
        return userService.findUserById(id);
    }


}
