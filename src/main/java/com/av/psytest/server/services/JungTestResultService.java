package com.av.psytest.server.services;

import com.av.psytest.server.models.JungTestResult;
import com.av.psytest.server.models.SelectedAnswer;
import com.av.psytest.server.models.User;
import com.av.psytest.server.repositories.JungTestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.*;

@Service
public class JungTestResultService {

    private JungTestResultRepository jungTestResultRepository;
    private UserService userService;

    @Autowired
    public JungTestResultService(JungTestResultRepository jungTestResultRepository,
                                 UserService userService) {
        this.jungTestResultRepository = jungTestResultRepository;
        this.userService = userService;
    }

    public void save(JungTestResult jungTestResult) {
        jungTestResultRepository.save(jungTestResult);
    }

    public Integer getResult(Principal principal,
                             UserService userService) {
        User curUser = userService.FindByUsername(principal.getName());
        if (!curUser.getJungTestResults().isEmpty()) {
            return curUser.getJungTestResults().get(0).getResult();
        }

        List<Long> trueAnswer = Arrays.asList(2L, 3L, 6L, 8L, 9L, 12L, 13L, 16L, 17L, 20L,
                21L, 24L, 25L, 28L, 29L, 31L, 33L, 35L, 38L, 39L);
        List<SelectedAnswer> userSelectedAnswers = curUser.getSelectedAnswers();
        Integer countOfAccordance = 0;

        for(SelectedAnswer selectedAnswer : userSelectedAnswers) {
            if (trueAnswer.contains(selectedAnswer.getAnswer().getId())) {
                countOfAccordance++;
            }
        }

        Integer result = countOfAccordance * 5;

        jungTestResultRepository.save(new JungTestResult(curUser, result));

        return result;
    }

    public Double getAvgResultByGenderBtwAge(Boolean sex,
                                           Integer minAge,
                                           Integer maxAge) {
        Date curDate = new Date();
        Calendar minCalendar = new GregorianCalendar();
        Calendar maxCalendar = new GregorianCalendar();
        minCalendar.set(Calendar.YEAR, curDate.getYear() - minAge);
        maxCalendar.set(Calendar.YEAR, curDate.getYear() - maxAge);
        List<User> users = userService.getUsersByDateBetweenAndGender(sex,
                maxCalendar.getTime(), minCalendar.getTime());
        Double sum = 0.0;
        Integer countOfRecords = 0;
        for(User user : users) {
            sum+= user.getJungTestResults().get(0).getResult();
            countOfRecords++;
        }
        return sum / countOfRecords;
    }
}
