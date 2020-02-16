package com.example.exercise.dao;

import java.util.List;

public interface Dao<T> {

    public T findById(Long id);
    public List<T> findAll();
    public List<T> findByCategory(String category);
    public void deleteById(Long id);
    public int update(T product);
    public int save(T product);
    
}