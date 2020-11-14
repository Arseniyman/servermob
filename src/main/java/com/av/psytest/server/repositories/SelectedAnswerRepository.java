package com.av.psytest.server.repositories;

import com.av.psytest.server.models.SelectedAnswer;
import org.springframework.data.repository.CrudRepository;

public interface SelectedAnswerRepository extends CrudRepository<SelectedAnswer, Long> {
}