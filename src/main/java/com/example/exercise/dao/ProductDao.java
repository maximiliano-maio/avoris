package com.example.exercise.dao;

import java.util.List;

import com.example.exercise.entities.Product;

public interface ProductDao {

    public List<Product> findAll();
    public List<Product> findByCategory(String category);
    public void deleteById(Long id);
    public int update(Product product);
    public int save(Product product);
    
}