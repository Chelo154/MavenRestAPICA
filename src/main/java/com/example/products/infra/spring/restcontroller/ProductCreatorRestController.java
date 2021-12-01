package com.example.products.infra.spring.restcontroller;

import com.example.products.app.controller.ProductCreatorController;
import com.example.products.app.dto.CreateProductDto;
import com.example.products.app.dto.CreateProductResponseDTO;
import com.example.products.app.service.ProductCreatorService;
import com.example.products.infra.data.arraylist.ProductsRepository;
import com.example.products.infra.uuid.UuidGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCreatorRestController {

    private ProductCreatorController controller;

    public ProductCreatorRestController(){
        this.controller = new ProductCreatorController(
                new ProductCreatorService(
                        new UuidGenerator(),
                        new ProductsRepository()
                )
        );
    }

    @PostMapping(value = "/product",consumes = "application/json",produces = "application/json")
    public CreateProductResponseDTO createProduct(@RequestBody CreateProductDto dto){
        return controller.createProduct(dto);
    }
}
