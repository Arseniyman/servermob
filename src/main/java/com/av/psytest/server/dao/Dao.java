package com.av.psytest.server.dao;

import java.util.List;

public interface Dao<T> {
    T getById(Long id);
    List<T> getAll();
    boolean insert (T t);
    boolean update (T t);
    boolean delete(T t);
}