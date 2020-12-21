package com.av.psytest.server.controllers;

import com.av.psytest.server.exceptions.ResourceNotFoundException;
import com.av.psytest.server.models.Questionnaire;
import com.av.psytest.server.services.JungTestService;
import com.av.psytest.server.services.QuestionnaireService;
import com.av.psytest.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
    private QuestionnaireService questionnaireService;
    private UserService userService;
    private JungTestService jungTestService;

    @Autowired
    public QuestionnaireController(QuestionnaireService questionnaireService,
                                   UserService userService,
                                   JungTestService jungTestService) {
        this.questionnaireService = questionnaireService;
        this.userService = userService;
        this.jungTestService = jungTestService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Questionnaire> getAll() {
        return questionnaireService.getAll();
    }

    @GetMapping("/{id}")
    public Questionnaire getQuestionById(@PathVariable(value = "id") Long id) {
        if (!questionnaireService.existById(id)) {
            throw new ResourceNotFoundException("Questionnaire not found with id " + id);
        }
        return questionnaireService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public void save(@RequestBody(required = false) Questionnaire questionnaire) {
        questionnaireService.save(questionnaire);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        questionnaireService.delete(id);
    }

    @GetMapping("/result")
    public Integer getResult(Principal principal) {
        return jungTestService.getResult(principal, userService);
    }
}