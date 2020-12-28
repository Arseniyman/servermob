package com.av.psytest.server.controllers;

import com.av.psytest.server.exceptions.UserAlreadyExistsException;
import com.av.psytest.server.models.User;
import com.av.psytest.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/reg")
    public ResponseEntity registerUser(@RequestBody(required = false) User user) {
        user.setDateOfRegister(new Date());
        user.setLastOnline(new Date());
        try {
            userService.save(user);
            return (ResponseEntity) ResponseEntity.status(HttpStatus.CREATED).body("User has been created");
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public List<User> getAllUsers(
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC)Pageable pageable
            ){
        return userService.getAll(pageable).getContent();
    }

    @GetMapping("/{email")
    public User getUserByUsename(@PathVariable(value = "email") String email) {
        return userService.FindByUsername(email);
    }

    @GetMapping("/myprofile")
    public User getMyProfile(Principal principal) {
        return userService.FindByUsername(principal.getName());
    }

    @PostMapping("/changepass")
    public ResponseEntity changePass(@RequestBody(required = true) String password,
                                     Principal principal) {
        userService.changePass(principal.getName(), password);
        return ResponseEntity.status(HttpStatus.OK).body("Password has been changed");
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable(value = "id") Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("User has been deleted");
    }
}