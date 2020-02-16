package com.example.exercise.entities;

public class Product {

    private Long id;

    private String productName;
    private String category;
    private String size;
    private int price;
    private String currency;
    private String color;

    public Product(){};

    public Product(Long id, String productName, String category, String size, int price, String currency, String color) {
        this.id = id;
        this.productName = productName;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public String getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getColor() {
        return color;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    


}