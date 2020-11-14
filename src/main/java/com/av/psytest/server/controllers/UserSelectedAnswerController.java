package com.av.psytest.server.controllers;

import com.av.psytest.server.models.UserSelectedAnswer;
import com.av.psytest.server.services.UserSelectedAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userselanswer")
public class UserSelectedAnswerController {
    private UserSelectedAnswerService service;

    @Autowired
    public UserSelectedAnswerController(UserSelectedAnswerService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserSelectedAnswer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserSelectedAnswer> getQuestionById(@PathVariable(value = "id") Long id) {
        UserSelectedAnswer userSelectedAnswer = service.getById(id);
        return ResponseEntity.ok().body(userSelectedAnswer);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public void save(@RequestBody(required = false) UserSelectedAnswer userSelectedAnswer) {
        service.save(userSelectedAnswer);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }
}