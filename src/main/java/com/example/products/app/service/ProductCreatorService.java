package com.example.products.app.service;

import com.example.products.app.dto.CreateProductDto;
import com.example.products.app.dto.CreateProductResponseDTO;
import com.example.products.app.interfaces.IProductSaver;
import com.example.products.app.interfaces.IdGenerator;
import com.example.products.domain.entities.Product;

public class ProductCreatorService {

    private IdGenerator idGenerator;

    private IProductSaver saver;

    public ProductCreatorService(IdGenerator idGenerator, IProductSaver saver){
        this.idGenerator = idGenerator;
        this.saver = saver;
    }

    public CreateProductResponseDTO createProduct(CreateProductDto dto){
        String id = idGenerator.generateId();

        Product newProduct = new Product(id,dto.getName(),dto.getPrice());

        saver.save(newProduct);

        return new CreateProductResponseDTO(newProduct.getId(), newProduct.getName(), newProduct.getPrice());

    }
}
