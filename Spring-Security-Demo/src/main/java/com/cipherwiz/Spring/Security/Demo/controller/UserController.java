package com.cipherwiz.Spring.Security.Demo.controller;

import com.cipherwiz.Spring.Security.Demo.model.User;
import com.cipherwiz.Spring.Security.Demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public User register(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PostMapping("login")
    public User login(@RequestBody User user){
        return
    }
}
