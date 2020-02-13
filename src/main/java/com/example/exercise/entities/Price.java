package com.example.exercise.entities;


public class Price {

    private Long priceId;
    private final PriceCurrency priceCurrency;
    private final Integer price;

    public Price(PriceCurrency priceCurrency, Integer price) {
        this.priceCurrency = priceCurrency;
        this.price = price;
    }

    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public PriceCurrency getPriceCurrency() {
        return priceCurrency;
    }

    public Integer getPrice() {
        return price;
    }

    
    
    
}