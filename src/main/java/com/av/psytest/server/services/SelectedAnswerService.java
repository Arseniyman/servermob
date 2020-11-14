package com.av.psytest.server.services;

import com.av.psytest.server.models.SelectedAnswer;
import com.av.psytest.server.repositories.SelectedAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectedAnswerService {
    private SelectedAnswerRepository repo;

    @Autowired
    public SelectedAnswerService(SelectedAnswerRepository repo) {
        this.repo = repo;
    }

    public void save(SelectedAnswer selectedAnswer) {
        repo.save(selectedAnswer);
    }

    public List<SelectedAnswer> getAll() {
        return (List<SelectedAnswer>) repo.findAll();
    }

    public SelectedAnswer getById(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}