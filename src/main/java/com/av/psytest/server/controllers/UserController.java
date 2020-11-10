package com.av.psytest.server.controllers;

import com.av.psytest.server.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/one")
    public User getUser() {
        return new User("Lela");
    }
}