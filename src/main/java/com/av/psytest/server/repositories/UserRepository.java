package com.av.psytest.server.repositories;

import com.av.psytest.server.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    boolean existsByUsername(String username);
    Page<User> findAll(Pageable pageable);
    List<User> findByDateOfBirthBetweenAndSexIs(Boolean sex, Date minDate, Date maxDate);
}