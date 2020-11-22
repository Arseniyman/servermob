package com.av.psytest.server.services;

import com.av.psytest.server.models.Question;
import com.av.psytest.server.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository questionRepo;

    @Autowired
    public QuestionService(QuestionRepository questionRepo) {
        this.questionRepo = questionRepo;
    }

    public void save(Question question) {
        questionRepo.save(question);
    }

    public List<Question> getAll() {
        return (List<Question>) questionRepo.findAll();
    }

    public Question getById(Long id) {
        return questionRepo.findById(id).get();
    }

    public void delete(Long id) {
        questionRepo.deleteById(id);
    }
    public boolean existById(Long id) {
        return questionRepo.existsById(id);
    }
}