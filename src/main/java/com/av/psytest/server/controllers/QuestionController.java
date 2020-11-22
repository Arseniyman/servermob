package com.av.psytest.server.controllers;

import com.av.psytest.server.exceptions.ResourceNotFoundException;
import com.av.psytest.server.models.Question;
import com.av.psytest.server.services.QuestionService;
import com.av.psytest.server.services.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;
    private QuestionnaireService questionnaireService;

    @Autowired
    public QuestionController(QuestionService questionService,
                              QuestionnaireService questionnaireService) {
        this.questionService = questionService;
        this.questionnaireService = questionnaireService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable(value = "id") Long id) {
        if (questionService.existById(id)) {
            return questionService.getById(id);
        } else {
            throw new ResourceNotFoundException("Question not found with id " + id);
        }
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/save/{questionnaireId}")
    public void save(@PathVariable Long questionnaireId,
                     @RequestBody(required = false) Question question) {
        if (questionnaireService.existById(questionnaireId)) {
            question.setQuestionnaire(questionnaireService.getById(questionnaireId));
            questionService.save(question);
        } else {
            throw new ResourceNotFoundException("Questionnaire not found with id " + questionnaireId);
        }
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        if (questionService.existById(id)) {
            questionService.delete(id);
        } else {
            throw new ResourceNotFoundException("Question not found with id " + id);
        }
    }
}