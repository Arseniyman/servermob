package com.av.psytest.server.services;

import com.av.psytest.server.models.Questionnaire;
import com.av.psytest.server.models.User;
import com.av.psytest.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public void save(User user) {
        repo.save(user);
    }

    public List<User> getAll() {
        return (List<User>) repo.findAll();
    }

    public User getById(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}