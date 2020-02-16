package com.example.exercise.services;

import java.util.List;

public interface IService<T> {

    public List<T> findAll();
    public List<T> findByCategory(String category);
    public int save(T product);
    
    
    
}