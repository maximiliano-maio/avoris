package com.example.exercise.entities;

public class Category {


    private Long productId;
    private final CategoryType categoryName;

    public Category(CategoryType categoryName) {
        this.categoryName = categoryName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public CategoryType getCategoryName() {
        return categoryName;
    }

    
    

    

}