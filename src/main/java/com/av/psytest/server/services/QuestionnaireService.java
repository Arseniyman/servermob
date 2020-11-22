package com.av.psytest.server.services;

import com.av.psytest.server.models.Questionnaire;
import com.av.psytest.server.repositories.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {
    private QuestionnaireRepository questionnaireRepo;

    @Autowired
    public QuestionnaireService(QuestionnaireRepository questionnaireRepo) {
        this.questionnaireRepo = questionnaireRepo;
    }

    public void save(Questionnaire questionnaire) {
        questionnaireRepo.save(questionnaire);
    }

    public List<Questionnaire> getAll() {
        return (List<Questionnaire>) questionnaireRepo.findAll();
    }

    public Questionnaire getById(Long id) {
        return questionnaireRepo.findById(id).get();
    }

    public void delete(Long id) {
        questionnaireRepo.deleteById(id);
    }
    public boolean existById(Long id) {
        return questionnaireRepo.existsById(id);
    }
}