package com.example.exercise.services;

import java.util.List;

import com.example.exercise.dao.ProductDao;
import com.example.exercise.entities.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public List<Product> findByPriceBiggerThan(int price) {
        return productDao.findByPriceBiggerThan(price);
    }

    @Override
    public List<Product> findByPriceLowerThan(int price) {
        return productDao.findByPriceLowerThan(price);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productDao.findByCategory(category);
    }

    
}