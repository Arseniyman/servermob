package com.av.psytest.server.services;

import com.av.psytest.server.models.SelectedAnswer;
import com.av.psytest.server.models.User;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Service
public class JungTestService {

    public Integer getResult(Principal principal,
                             UserService userService) {
        List<Long> trueAnswer = Arrays.asList(2L, 3L, 6L, 8L, 9L, 12L, 13L, 16L, 17L, 20L,
                21L, 24L, 25L, 28L, 29L, 31L, 33L, 35L, 38L, 39L);
        User curUser = userService.FindByUsername(principal.getName());
        List<SelectedAnswer> userSelectedAnswers = curUser.getSelectedAnswers();
        Integer countOfAccordance = 0;

        for(SelectedAnswer selectedAnswer : userSelectedAnswers) {
            if (trueAnswer.contains(selectedAnswer.getAnswer().getId())) {
                countOfAccordance++;
            }
        }

        return countOfAccordance * 5;
    }
}
