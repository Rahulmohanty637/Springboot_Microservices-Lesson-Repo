package com.cipherwiz.Spring.Security.Demo.service;

import com.cipherwiz.Spring.Security.Demo.dao.UserRepo;
import com.cipherwiz.Spring.Security.Demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public User saveUser(User user){
        return repo.save(user);
    }
}
