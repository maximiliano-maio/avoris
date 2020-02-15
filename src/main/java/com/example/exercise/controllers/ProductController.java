package com.example.exercise.controllers;

import java.util.List;

import com.example.exercise.entities.Product;
import com.example.exercise.services.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value = "Products", description = "Find product information", tags = ("products, prices"))
public class ProductController {

    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(
        value="/api/{productId}", 
        method = RequestMethod.GET,
        headers = {
            "Accept=application/json"
        },
        produces = "application/json")
    @ApiOperation(value = "Get product by Category", notes = "Get product information by Category", nickname = "getProductByCategory")
    public List<Product> getProductByCategory(@PathVariable String category) {
        return productService.findByCategory(category);
    }
    
    
}