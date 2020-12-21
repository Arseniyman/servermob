package com.av.psytest.server.controllers;

import com.av.psytest.server.services.JungTestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller("/stat")
public class JungTestResultController {
    private JungTestResultService jungTestResultService;

    @Autowired
    public JungTestResultController(JungTestResultService jungTestResultService) {
        this.jungTestResultService = jungTestResultService;
    }

    @GetMapping("/{sex}/{minAge}/{maxAge}")
    public Double getAvgResultByGenderBtwAge(
            @PathVariable(value = "sex", required = true) Boolean sex,
            @PathVariable(value = "minAge", required = true) Integer minAge,
            @PathVariable(value = "maxAge", required = true) Integer maxAge
    ) {
        return jungTestResultService.getAvgResultByGenderBtwAge(sex, minAge, maxAge);
    }
}