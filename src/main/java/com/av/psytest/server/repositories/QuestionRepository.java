package com.av.psytest.server.repositories;

import com.av.psytest.server.models.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}