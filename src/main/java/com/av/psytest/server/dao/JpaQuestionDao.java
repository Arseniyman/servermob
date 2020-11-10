package com.av.psytest.server.dao;

import com.av.psytest.server.models.Question;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaQuestionDao implements Dao<Question> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Question getById(Long id) {
        return em.find(Question.class, id);
    }

    @Override
    public List<Question> getAll() {
        return null;
    }

    @Override
    public boolean insert(Question question) {
        return false;
    }

    @Override
    public boolean update(Question question) {
        return false;
    }

    @Override
    public boolean delete(Question question) {
        return false;
    }
}