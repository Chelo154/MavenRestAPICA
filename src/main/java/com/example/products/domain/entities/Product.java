package com.example.products.domain.entities;

import com.example.products.domain.valuebjects.Price;

public class Product {
    private String id;
    private String name;
    private Price price;


    public Product(String id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = new Price(price);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price.getValue();
    }

    public void updatePrice(double amount){
        price.updatePrice(amount);
    }

    public void increasePriceByPercentage(double percentage){
        price.increaseByPercentage(percentage);
    }

    public void increasePriceByAmount(double amount){
        price.increaseByAmount(amount);
    }

    public void decreasePriceByPercentage(double percentage){
        this.price.decreaseByPercentage(percentage);
    }

    public void decreasePriceByAmount(double amount){
        this.price.decreaseByAmount(amount);
    }

    public double pricePerQuantity(int quantity){
        return this.price.pricePerQuantity(quantity);
    }
}
