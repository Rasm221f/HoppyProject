package org.example.repository;


import java.util.List;

public interface GenericDAO<T, ID> {
        T findById(ID id);
        List<T> findAll();
        T save(T entity);
        void delete(T entity);
        void deleteById(ID id);
    }

