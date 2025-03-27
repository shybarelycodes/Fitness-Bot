package com.fitness.controller;

import model.User;
import repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        Optional<User> existing = userRepository.findByUsername(user.getUsername());
        if (existing.isPresent()) {
            return "Username is already taken";
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> found = userRepository.findByUsername(user.getUsername());
        if (found.isPresent() && encoder.matches(user.getPassword(), found.get().getPassword())) {
            return "Login successful";
        }
        return "Invalid credentials";
    }
}
