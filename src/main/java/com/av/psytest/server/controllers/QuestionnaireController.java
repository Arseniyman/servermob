package com.av.psytest.server.controllers;

import com.av.psytest.server.exceptions.ResourceNotFoundException;
import com.av.psytest.server.models.Questionnaire;
import com.av.psytest.server.models.SelectedAnswer;
import com.av.psytest.server.models.User;
import com.av.psytest.server.services.AnswerService;
import com.av.psytest.server.services.QuestionnaireService;
import com.av.psytest.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
    private QuestionnaireService questionnaireService;
    private UserService userService;

    @Autowired
    public QuestionnaireController(QuestionnaireService questionnaireService,
                                   UserService userService) {
        this.questionnaireService = questionnaireService;
        this.userService = userService;
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
    public Short getResult(Principal principal) {
        List<Long> trueAnswer = Arrays.asList(2L, 3L, 6L, 8L, 9L, 12L, 13L, 16L, 17L, 20L,
                21L, 24L, 25L, 28L, 29L, 31L, 33L, 35L, 38L, 39L);
        User cutUser = userService.FindByUsername(principal.getName());
        List<SelectedAnswer> userSelectedAnswers = cutUser.getSelectedAnswers();
        Short countOfAccordance = 0;

        for(SelectedAnswer selAnsw : userSelectedAnswers) {
            if (trueAnswer.contains(selAnsw.getId())) {
                countOfAccordance++;
            }
        }

        return countOfAccordance;
    }
}