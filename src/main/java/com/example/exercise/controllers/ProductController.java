package com.example.exercise.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.exercise.entities.Product;
import com.example.exercise.model.ProductDto;
import com.example.exercise.services.ProductService;
import com.example.exercise.utils.ProductConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    private ProductConverter ProductConverter;

    @RequestMapping(
        value="/api/{productId}", 
        method = RequestMethod.GET,
        headers = {
            "Accept=application/json"
        },
        produces = "application/json")
    @ApiOperation(value = "Get product by Category", notes = "Get product information by Category", nickname = "getProductByCategory")
    public List<ProductDto> getProductByCategory(@PathVariable String category) {
        List<Product> listProducts = productService.findByCategory(category);
        List<ProductDto> listDto = listProducts.stream().map(ProductConverter::convertFromEntity).collect(Collectors.toList());
        return listDto;
    }
    

    @RequestMapping(
        value="/admin/save", 
        method = RequestMethod.POST,
        headers = {
            "Accept=application/json"
        },
        produces = "application/json")
    @ApiOperation(value = "Insert product", notes = "Insert/Save product information", nickname = "saveProduct")
    public int saveProduct(@RequestBody ProductDto productDto) {
        Product product = ProductConverter.convertFromDto(productDto);
        return productService.save(product);
    }
    
}