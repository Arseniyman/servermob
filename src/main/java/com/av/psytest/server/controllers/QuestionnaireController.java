package com.av.psytest.server.controllers;

import com.av.psytest.server.exceptions.ResourceNotFoundException;
import com.av.psytest.server.models.Questionnaire;
import com.av.psytest.server.services.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
    private QuestionnaireService service;

    @Autowired
    public QuestionnaireController(QuestionnaireService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Questionnaire> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Questionnaire getQuestionById(@PathVariable(value = "id") Long id) {
        if (!service.existById(id)) {
            throw new ResourceNotFoundException("Questionnaire not found with id " + id);
        }
        return service.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public void save(@RequestBody(required = false) Questionnaire questionnaire) {
        service.save(questionnaire);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }
}