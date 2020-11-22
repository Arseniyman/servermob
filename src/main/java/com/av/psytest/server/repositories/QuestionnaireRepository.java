package com.av.psytest.server.repositories;

import com.av.psytest.server.models.Questionnaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireRepository extends CrudRepository<Questionnaire, Long> {
}