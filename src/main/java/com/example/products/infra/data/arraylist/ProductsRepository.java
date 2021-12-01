package com.example.products.infra.data.arraylist;

import com.example.products.app.interfaces.IProductSaver;
import com.example.products.domain.entities.Product;

import java.util.ArrayList;

public class ProductsRepository implements IProductSaver {

    private ArrayList<Product> products;

    public ProductsRepository(){
        this.products = new ArrayList<Product>();
    }
    @Override
    public void save(Product newProduct) {
        products.add(newProduct);
    }
}
