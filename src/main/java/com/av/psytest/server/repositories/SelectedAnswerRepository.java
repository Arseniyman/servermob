package com.av.psytest.server.repositories;

import com.av.psytest.server.models.SelectedAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectedAnswerRepository extends CrudRepository<SelectedAnswer, Long> {
    List<SelectedAnswer> findAllByUserUsername(String username);
}