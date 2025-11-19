package com.foodwaste.foodwaste.controller;

// package com.foodwaste.foodwaste.controller;

import com.foodwaste.foodwaste.model.user;
import com.foodwaste.foodwaste.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/foodwaste/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestBody user user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return "Username already taken.";
        }
        user.setPassword(hashPassword(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody user user) {
        user existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(hashPassword(user.getPassword()))) {
            return "Login successful!";
        } else {
            return "Invalid credentials. Contact admin if needed.";
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
