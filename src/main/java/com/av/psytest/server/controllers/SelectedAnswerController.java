package com.av.psytest.server.controllers;

import com.av.psytest.server.models.SelectedAnswer;
import com.av.psytest.server.models.User;
import com.av.psytest.server.services.AnswerService;
import com.av.psytest.server.services.SelectedAnswerService;
import com.av.psytest.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/selanswer")
public class SelectedAnswerController {
    private SelectedAnswerService selAnsService;
    private AnswerService answerService;
    private UserService userService;
    
    @Autowired
    public SelectedAnswerController(SelectedAnswerService selAnsService) {
        this.selAnsService = selAnsService;
    }

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<SelectedAnswer> getAllSelAnswByUsername(Principal principal) {
        return selAnsService.getAllSelAnswByUsername(principal.getName());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SelectedAnswer> getQuestionById(@PathVariable(value = "id") Long id) {
        SelectedAnswer selectedAnswer = selAnsService.getById(id);
        return ResponseEntity.ok().body(selectedAnswer);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public void save(@RequestBody(required = true) Long answerId,
                     Principal principal) {
        User curUser = userService.FindByUsername(principal.getName());
        curUser.setLastOnline(new Date());
        SelectedAnswer selAnsw = new SelectedAnswer(
                answerService.getById(answerId),
                curUser
        );
        selAnsService.save(selAnsw);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        selAnsService.delete(id);
    }
}