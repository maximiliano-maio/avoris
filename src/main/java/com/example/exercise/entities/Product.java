package com.example.exercise.entities;

public class Product {

    private Long id;

    private final String productName;
    private final Size size;
    private final Price price;
    private final Category category;
    private final Color color;

    public Product(String productName, Size size, Price price, Category category, Color color) {
        this.productName = productName;
        this.size = size;
        this.price = price;
        this.category = category;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public Size getSize() {
        return size;
    }

    public Price getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public Color getColor() {
        return color;
    }

    

    


}