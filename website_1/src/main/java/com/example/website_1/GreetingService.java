package com.example.website_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final UserRepository userRepository;

    @Autowired
    public GreetingService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createAndGreetUser (String name) {
        User newUser = new User(name);
        User savedUser = userRepository.save(newUser);
        return "Hello " + savedUser.getName() + "Your Id is " + savedUser.getId();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User updateUserName(Long id, String newName) {
        User userToUpdate = getUserById(id);
        userToUpdate.setName(newName);
        return userRepository.save(userToUpdate);
    }

    public void deleteUser (Long id) {
        if (!userRepository.existsById(id))
            throw new RuntimeException("User name not found with id: " + id);
        userRepository.deleteById(id);
    }
}