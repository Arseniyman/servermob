package com.av.psytest.server.repositories;

import com.av.psytest.server.models.UserSelectedAnswer;
import org.springframework.data.repository.CrudRepository;

public interface UserSelectedAnswerRepository extends CrudRepository<UserSelectedAnswer, Long> {
}