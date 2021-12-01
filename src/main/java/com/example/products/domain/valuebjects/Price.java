package com.example.products.domain.valuebjects;

import com.example.products.domain.exceptions.InvalidPriceException;

public class Price {

    private double value;

    public Price(double value) throws InvalidPriceException {
        this.validate(value);

        this.value = value;
    }

    private void validate(double value) throws InvalidPriceException {
        if (value < 0) throw new InvalidPriceException();
    }

    public double getValue() {
        return value;
    }

    public void updatePrice(double newValue) throws InvalidPriceException {
        this.validate(newValue);
        this.value = newValue;
    }

    public void increaseByPercentage(double percentage){
        value += value * percentage / 100;
    }

    public void increaseByAmount(double amount){
        value += amount;
    }

    public void decreaseByPercentage(double percentage) throws InvalidPriceException {
        double updated = value;

        updated -= value *percentage / 100;

        updatePrice(updated);
    }

    public void decreaseByAmount(double amount) throws InvalidPriceException {
        double updated = value;

        updated -= amount;

        updatePrice(updated);
    }

    public double pricePerQuantity(int quantity){
        return value * quantity;
    }
}
