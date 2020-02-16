package com.example.exercise.services;

import java.util.List;

import com.example.exercise.entities.Product;

public interface ProductService {

    public List<Product> findAll();
    public List<Product> findByCategory(String category);
    public int save(Product product);
    
    
    
}