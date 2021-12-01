package com.example.products.app.service;

import com.example.products.app.dto.CreateProductDto;
import com.example.products.app.interfaces.IProductSaver;
import com.example.products.app.interfaces.IdGenerator;
import com.example.products.domain.exceptions.InvalidPriceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ProductCreatorServiceTest {

    private ProductCreatorService service;

    @Before
    public void before(){

        IdGenerator mockedIdGenerator = mock(IdGenerator.class);

        IProductSaver saver = mock(IProductSaver.class);

        when(mockedIdGenerator.generateId()).thenReturn("ABC123");

        doNothing().when(saver).save(any());

        service = new ProductCreatorService(mockedIdGenerator,saver);

    }

    @Test
    public void testService(){
        CreateProductDto dto = new CreateProductDto("Coke Cola",20.0);

        service.createProduct(dto);
    }

    @Test
    public void testFailedPrice(){
        try{
            CreateProductDto dto = new CreateProductDto("Coke Cola",-1.0);

            service.createProduct(dto);

            Assert.fail("This is not a valid price for creation");
        }catch (InvalidPriceException ignored){}

    }

}