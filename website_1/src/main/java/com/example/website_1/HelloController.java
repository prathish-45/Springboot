package com.example.website_1;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class HelloController {

    private final GreetingService greetingService;

    @Autowired
    public HelloController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/create-user")
    public String hello (@RequestParam (value = "name", defaultValue = "world") String name) {
        return greetingService.createAndGreetUser(name);
    }

    @GetMapping("/user/{id}")
    public User findUserById (@PathVariable Long id) {
        return greetingService.getUserById(id);
    }

    @PutMapping("/user/{id}")
    public User updateUser (@PathVariable Long id, @RequestBody Map<String, String> request) {
        String newName = request.get("name");
        System.out.println(newName);
        return greetingService.updateUserName(id, newName);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUserById (@PathVariable Long id) {
        greetingService.deleteUser(id);
        return "User with id " + id + " has been deleted successfully.";
    }

}