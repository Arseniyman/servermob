package com.av.psytest.server.repositories;

import com.av.psytest.server.models.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
}