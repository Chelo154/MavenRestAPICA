package com.example.products.app.dto;

import com.example.products.app.exceptions.MissingCreateProductArgumentsException;

public class CreateProductDto {
    private String name;
    private Double price;

    public CreateProductDto(){

    }

    public CreateProductDto(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void validate(){
        if(!(price != null && name != null))
            throw new MissingCreateProductArgumentsException(this.getClass().getSimpleName(),"price,name");
    }
}
