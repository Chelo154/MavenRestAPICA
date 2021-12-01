package com.example.products.app.controller;

import com.example.products.app.dto.CreateProductDto;
import com.example.products.app.dto.CreateProductResponseDTO;
import com.example.products.app.exceptions.MissingCreateProductArgumentsException;
import com.example.products.app.service.ProductCreatorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ProductCreatorControllerTest {

    private ProductCreatorController controller;

    @Before
    public void setUp() throws Exception {
        ProductCreatorService service = mock(ProductCreatorService.class);

        when(service.createProduct(any())).thenReturn(new
                CreateProductResponseDTO("ABC123",
                "Guepardex",
                20.00));

        controller = new ProductCreatorController(service);
    }

    @Test
    public void testCreateController(){
        CreateProductDto dto = new CreateProductDto("Coke",20.0);

        controller.createProduct(dto);
    }

    @Test
    public void testMissingName(){
        try{
            CreateProductDto dto = new CreateProductDto(null,10.0);
            controller.createProduct(dto);
        }catch (MissingCreateProductArgumentsException error){
            String expected = "Some arguments are not given for creating the product, arguments are price,name";
            Assert.assertEquals(expected,error.getMessage());
        }
    }

    @Test
    public void testMissingPrice(){
        try{
            CreateProductDto dto = new CreateProductDto(null,null);
            controller.createProduct(dto);
        }catch (MissingCreateProductArgumentsException error){
            String expected = "Some arguments are not given for creating the product, arguments are price,name";
            Assert.assertEquals(expected,error.getMessage());
        }
    }

    @Test
    public void testMissingBothParams(){
        try{
            CreateProductDto dto = new CreateProductDto(null,null);
            controller.createProduct(dto);
        }catch (MissingCreateProductArgumentsException error){
            String expected = "Some arguments are not given for creating the product, arguments are price,name";
            Assert.assertEquals(expected,error.getMessage());
        }
    }




}