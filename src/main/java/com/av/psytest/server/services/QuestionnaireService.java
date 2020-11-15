package com.av.psytest.server.services;

import com.av.psytest.server.models.Questionnaire;
import com.av.psytest.server.repositories.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {
    private QuestionnaireRepository repo;

    @Autowired
    public QuestionnaireService(QuestionnaireRepository repo) {
        this.repo = repo;
    }

    public void save(Questionnaire questionnaire) {
        repo.save(questionnaire);
    }

    public List<Questionnaire> getAll() {
        return (List<Questionnaire>) repo.findAll();
    }

    public Questionnaire getById(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
    public boolean existById(Long id) {
        return repo.existsById(id);
    }
}