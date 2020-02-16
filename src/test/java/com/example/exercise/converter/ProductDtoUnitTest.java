package com.example.exercise.converter;

import static org.junit.Assert.assertEquals;

import com.example.exercise.entities.Product;
import com.example.exercise.model.ProductDto;
import com.example.exercise.utils.ProductConverter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ProductDtoUnitTest {

    @Autowired
    private ProductConverter productConverter;

    @TestConfiguration
    public static class ProductDtoConfig{
        @Bean
        public ProductConverter productConverter(){
            return new ProductConverter();
        }

    }

    @Test
    public void whenConvertingProductEntitytoProductDto_thenCorrect(){
        Product product = new Product(11L,"testProduct","test", "small", 10, "USD", "red");
        ProductDto productDto = productConverter.convertFromEntity(product);

        assertEquals(product.getProductName(), productDto.getProductName());
        assertEquals(product.getSize(), productDto.getSize());
        assertEquals(product.getPrice(), productDto.getPrice());
    }
    
}