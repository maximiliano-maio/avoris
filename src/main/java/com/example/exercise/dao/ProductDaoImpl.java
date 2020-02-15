package com.example.exercise.dao;

import java.util.List;

import com.example.exercise.entities.Product;
import com.example.exercise.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByPriceBiggerThan(int price) {
        return productRepository.findByPriceBiggerThan(price);
    }

    @Override
    public List<Product> findByPriceLowerThan(int price) {
        return productRepository.findByPriceLowerThan(price);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public int update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public int insert(Product product) {
        return productRepository.insert(product);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }


    
}