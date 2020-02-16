package com.example.exercise.repository;


import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import com.example.exercise.configuration.dbConfiguration;
import com.example.exercise.entities.Product;
import com.example.exercise.repositories.ProductRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ProductRepository.class, dbConfiguration.class})
public class ProductRepositoryIntegTest {

    @Autowired
    private ProductRepository productRepository;

    
    @Test
    public void whenSaveProduct_thenReturnPositiveInt(){
        Product product = new Product(10L,"testProduct","test", "small", 10, "USD", "red");
        int result = productRepository.save(product);

        assertThat(result).isGreaterThan(-1);

    }

    @Test
    public void whenFindByValidId_thenReturnProduct(){
        Product product = productRepository.findById(1L);
        assertEquals("red",product.getColor());
    }

    @Test
    public void whenFindByInvalidId_thenThrowsException(){
        assertThrows(EmptyResultDataAccessException.class, () -> productRepository.findById(1000L));
        
    }

    @Test
    public void whenFindByValidCategory_thenReturnProduct(){
        List<Product> products = productRepository.findByCategory("sport");
        assertThat(products).hasSize(2);
    }

    @Test
    public void whenFindByInvalidCategory_thenReturnEmptyListProduct(){
        List<Product> products = productRepository.findByCategory("nada");
        assertThat(products).hasSize(0);
    }

    @Test
    public void whenFindAll_thenReturnList(){
        List<Product> products = productRepository.findAll();
        assertThat(products).hasSize(8);
    }

    @Test
    public void whenUpdateProduct_thenReturnPositiveInt(){
        Product product = productRepository.findById(2L);
        product.setId(100L);
        int result = productRepository.save(product);

        assertThat(result).isGreaterThan(0);
    }
    
}