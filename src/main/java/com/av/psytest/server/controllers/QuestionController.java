package com.av.psytest.server.controllers;

import com.av.psytest.server.models.Question;
import com.av.psytest.server.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quest")
public class QuestionController {

    private QuestionService service;

    @Autowired
    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Question> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable(value = "id") Long id) {
        Question question = service.getById(id);
        return ResponseEntity.ok().body(question);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public void save(@Validated @RequestBody Question question) {
        service.save(question);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }
}