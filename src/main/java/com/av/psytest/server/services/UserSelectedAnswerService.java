package com.av.psytest.server.services;

import com.av.psytest.server.models.UserSelectedAnswer;
import com.av.psytest.server.repositories.UserSelectedAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSelectedAnswerService {
    private UserSelectedAnswerRepository repo;

    @Autowired
    public UserSelectedAnswerService(UserSelectedAnswerRepository repo) {
        this.repo = repo;
    }

    public void save(UserSelectedAnswer userSelectedAnswer) {
        repo.save(userSelectedAnswer);
    }

    public List<UserSelectedAnswer> getAll() {
        return (List<UserSelectedAnswer>) repo.findAll();
    }

    public UserSelectedAnswer getById(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}