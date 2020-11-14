package com.av.psytest.server.controllers;

import com.av.psytest.server.models.Answer;
import com.av.psytest.server.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    private AnswerService service;

    @Autowired
    public AnswerController(AnswerService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Answer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> getQuestionById(@PathVariable(value = "id") Long id) {
        Answer answer = service.getById(id);
        return ResponseEntity.ok().body(answer);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public void save(@RequestBody(required = false) Answer answer) {
        service.save(answer);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }
}