package com.cipherwiz.Spring.Security.Demo.dao;

import com.cipherwiz.Spring.Security.Demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
