package com.av.psytest.server.controllers;

import com.av.psytest.server.models.Role;
import com.av.psytest.server.models.User;
import com.av.psytest.server.repositories.RoleRepository;
import com.av.psytest.server.services.AppUserDetailsService;
import com.av.psytest.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/reg")
    public void registerUser(@RequestBody(required = false) User user) {
        userService.save(user);
    }
}