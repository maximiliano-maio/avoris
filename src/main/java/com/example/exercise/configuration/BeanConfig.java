package com.example.exercise.configuration;

import com.example.exercise.utils.ProductConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {


    @Bean
    public ProductConverter productConverter(){
        return new ProductConverter();
    }
    
}