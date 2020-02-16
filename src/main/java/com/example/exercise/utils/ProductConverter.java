package com.example.exercise.utils;

import com.example.exercise.entities.Product;
import com.example.exercise.model.ProductDto;

public class ProductConverter extends Converter<ProductDto, Product> {


    public ProductConverter() {
        super(ProductConverter::convertToProduct, ProductConverter::convertToProductDto);
    }

    private static ProductDto convertToProductDto(Product product) {
        return new ProductDto(product.getId(),product.getProductName(),product.getCategory(), product.getSize(), product.getPrice(), product.getCurrency(), product.getColor());
    }
    
    private static Product convertToProduct(ProductDto product) {
        return new Product(product.getId(),product.getProductName(),product.getCategory(), product.getSize(), product.getPrice(), product.getCurrency(), product.getColor());
    }

}