package com.av.psytest.server.services;

import com.av.psytest.server.models.Answer;
import com.av.psytest.server.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    private AnswerRepository repo;

    @Autowired
    public AnswerService(AnswerRepository repo) {
        this.repo = repo;
    }

    public void save(Answer answer) {
        repo.save(answer);
    }

    public List<Answer> getAll() {
        return (List<Answer>) repo.findAll();
    }

    public Answer getById(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
    public boolean existById(Long id) {
        return repo.existsById(id);
    }
}