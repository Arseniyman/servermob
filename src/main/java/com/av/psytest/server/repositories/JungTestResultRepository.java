package com.av.psytest.server.repositories;

import com.av.psytest.server.models.JungTestResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JungTestResultRepository extends CrudRepository<JungTestResult, Long> {
}