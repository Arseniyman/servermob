package com.av.psytest.server.controllers;

import com.av.psytest.server.models.SelectedAnswer;
import com.av.psytest.server.services.SelectedAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/selanswer")
public class SelectedAnswerController {
    private SelectedAnswerService service;

    @Autowired
    public SelectedAnswerController(SelectedAnswerService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<SelectedAnswer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SelectedAnswer> getQuestionById(@PathVariable(value = "id") Long id) {
        SelectedAnswer selectedAnswer = service.getById(id);
        return ResponseEntity.ok().body(selectedAnswer);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public void save(@RequestBody(required = false) SelectedAnswer  selectedAnswer) {
        service.save(selectedAnswer);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }
}