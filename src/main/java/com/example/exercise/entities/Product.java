package com.example.exercise.entities;

public class Product {

    private Long id;

    private final String productName;
    private final int size;
    private final int price;
    private final int currency;
    private final String color;

    public Product(String productName, int size, int price, int currency, String color) {
        this.productName = productName;
        this.size = size;
        this.price = price;
        this.currency = currency;
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

    public int getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public int getCurrency() {
        return currency;
    }

    public String getColor() {
        return color;
    }

    
    


}