package com.av.psytest.server.services;

import com.av.psytest.server.models.Question;
import com.av.psytest.server.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository repo;

    @Autowired
    public QuestionService(QuestionRepository repo) {
        this.repo = repo;
    }

    public void save(Question question) {
        repo.save(question);
    }

    public List<Question> getAll() {
        return (List<Question>) repo.findAll();
    }

    public Question getById(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
    public boolean existById(Long id) {
        return repo.existsById(id);
    }
}