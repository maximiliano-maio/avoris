package com.example.exercise.controllers;

import com.example.exercise.entities.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);


    @RequestMapping(
        value="/api/{productId}", 
        method = RequestMethod.GET,
        headers = {
            "Accept=application/json"
        },
        produces = "application/json")
    public Product getProductById(@PathVariable Long productId) {
        return null;
    }
    
    
}