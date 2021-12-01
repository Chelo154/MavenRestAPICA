package com.example.products.app.interfaces;

import com.example.products.domain.entities.Product;

import java.util.List;

public interface IProductSaver {
    void save(Product newProduct);
}
