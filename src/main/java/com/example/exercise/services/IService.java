package com.example.exercise.services;

import java.util.List;

public interface IService<T> {

    public T findById(Long id);
    public List<T> findAll();
    public List<T> findByCategory(String category);
    public int save(T product);
    public void deleteById(Long id);
    
    
    
}