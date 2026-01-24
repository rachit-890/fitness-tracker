package com.project.fitness.controller;

import com.project.fitness.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AuthController {

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

}
