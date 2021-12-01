package com.example.products.app.controller;

import com.example.products.app.dto.CreateProductDto;
import com.example.products.app.dto.CreateProductResponseDTO;
import com.example.products.app.service.ProductCreatorService;

public class ProductCreatorController {

    private ProductCreatorService service;

    public ProductCreatorController(ProductCreatorService service){
        this.service = service;
    }

    public CreateProductResponseDTO createProduct(CreateProductDto dto){
        dto.validate();

        return service.createProduct(dto);
    }
}
