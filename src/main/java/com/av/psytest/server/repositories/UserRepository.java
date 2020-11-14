package com.av.psytest.server.repositories;

import com.av.psytest.server.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}