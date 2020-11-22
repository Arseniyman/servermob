package com.av.psytest.server.controllers;

import com.av.psytest.server.exceptions.ResourceNotFoundException;
import com.av.psytest.server.models.Answer;
import com.av.psytest.server.services.AnswerService;
import com.av.psytest.server.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    private AnswerService answerService;
    private QuestionService questionService;

    @Autowired
    public AnswerController(AnswerService answerService,
                            QuestionService questionService) {
        this.answerService = answerService;
        this.questionService = questionService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Answer> getAll() {
        return answerService.getAll();
    }

    @GetMapping("/{id}")
    public Answer getQuestionById(@PathVariable(value = "id") Long id) {
        if (answerService.existById(id)) {
            return answerService.getById(id);
        } else {
            throw new ResourceNotFoundException("Answer not found with id " + id);
        }
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/save/{questionId}")
    public void save(@PathVariable Long questionId,
                     @RequestBody(required = false) Answer answer) {
        if (questionService.existById(questionId)) {
            answer.setQuestion(questionService.getById(questionId));
            answerService.save(answer);
        } else {
            throw new ResourceNotFoundException("Question not found with id " + questionId);
        }
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        if (answerService.existById(id)) {
            answerService.delete(id);
        } else {
            throw new ResourceNotFoundException("Answer not found with id " + id);
        }
    }
}