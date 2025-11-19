package com.foodwaste.foodwaste.repository;

import com.foodwaste.foodwaste.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user, Long> {
    user findByUsername(String username);
}