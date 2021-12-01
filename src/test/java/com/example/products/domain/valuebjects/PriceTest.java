package com.example.products.domain.valuebjects;

import com.example.products.domain.exceptions.InvalidPriceException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriceTest {


    @Test
    public void testCorrectedPrice(){
        try {
            Price price = new Price(12);
        }catch (InvalidPriceException error){
            Assert.fail("This is a valid price");
        }
    }

    @Test
    public void test0Price(){
        try{
            Price price = new Price(0);
        }catch (InvalidPriceException error){
            Assert.fail("This is a valid price");
        }
    }

    @Test
    public void testInvalidPrice(){
        try{
            Price price = new Price(-1);

            Assert.fail("This is not a valid price");
        }catch (InvalidPriceException ignored){}
    }

    @Test
    public void testUpdatingPrice(){
        try{
            Price price = new Price(1);
            price.updatePrice(2);
            Assert.assertEquals(price.getValue(),2,0);
        }catch (InvalidPriceException error){
            Assert.fail("Updated price is valid");
        }
    }

    @Test
    public void testUpdatingInvalidPrice(){
        try{
            Price price = new Price(1);
            price.updatePrice(-1);

            Assert.fail("Updated price is not valid");
        }catch (InvalidPriceException ignored){}
    }

    @Test
    public void testIncreasePriceByPercentage(){
        Price price = new Price(100);

        price.increaseByPercentage(10);

        Assert.assertEquals(price.getValue(),110,0);
    }

    @Test
    public void testIncreaseByAmount(){
        Price price = new Price(100);

        price.increaseByAmount(100);

        Assert.assertEquals(price.getValue(),200,0);
    }

    @Test
    public void testDecreaseByPercentage(){
        Price price = new Price(100);

        price.decreaseByPercentage(10);

        Assert.assertEquals(price.getValue(),90,0);
    }

    @Test
    public void testInvalidDecreaseByPercentage(){
        try{
            Price price = new Price(100);

            price.decreaseByPercentage(120);

            Assert.fail("This is an invalid decrease");
        }catch (InvalidPriceException ignored){}
    }

    @Test
    public void testDecreaseByAmount(){
        Price price = new Price(100);

        price.decreaseByAmount(100);

        Assert.assertEquals(price.getValue(),0,0);
    }

    @Test
    public void testInvalidDecreaseByAmount(){
        try{
            Price price = new Price(100);

            price.decreaseByAmount(200);

            Assert.fail("This is an invalid amount decrease");
        }catch (InvalidPriceException ignored){}
    }

    @Test
    public void testPricePerQuantity(){
        Price price = new Price(100);

        double result = price.pricePerQuantity(5);

        Assert.assertEquals(500,result,0);

    }


}