package com.av.psytest.server.services;

import com.av.psytest.server.models.SelectedAnswer;
import com.av.psytest.server.repositories.SelectedAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectedAnswerService {
    private SelectedAnswerRepository selecAnswRepo;

    @Autowired
    public SelectedAnswerService(SelectedAnswerRepository selecAnswRepo) {
        this.selecAnswRepo = selecAnswRepo;
    }

    public void save(SelectedAnswer selectedAnswer) {
        selecAnswRepo.save(selectedAnswer);
    }

    public List<SelectedAnswer> getAllSelAnswByUsername(String username) {
        return selecAnswRepo.findAllByUserUsername(username);
    }

    public SelectedAnswer getById(Long id) {
        return selecAnswRepo.findById(id).get();
    }

    public void delete(Long id) {
        selecAnswRepo.deleteById(id);
    }
}