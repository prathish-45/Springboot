
package com.prathish.studentapi.service;

import com.prathish.studentapi.models.Students;
import com.prathish.studentapi.models.User;
import com.prathish.studentapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser (User user) {
        return userRepository.save(user);
    }

    public User getId (Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Student is not found"));
    }

}
