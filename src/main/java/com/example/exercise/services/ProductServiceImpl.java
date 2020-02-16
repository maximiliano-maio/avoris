package com.example.exercise.services;

import java.util.List;

import com.example.exercise.dao.Dao;
import com.example.exercise.entities.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IService<Product> {

    @Autowired
    private Dao<Product> productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }
    @Override
    public List<Product> findByCategory(String category) {
        return productDao.findByCategory(category);
    }

    @Override
    public int save(Product product) {
        return productDao.save(product);
    }

    
}