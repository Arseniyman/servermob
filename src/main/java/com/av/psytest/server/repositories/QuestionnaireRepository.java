package com.av.psytest.server.repositories;

import com.av.psytest.server.models.Questionnaire;
import org.springframework.data.repository.CrudRepository;

public interface QuestionnaireRepository extends CrudRepository<Questionnaire, Long> {
}