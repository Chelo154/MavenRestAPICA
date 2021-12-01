package com.example.products.infra.data.mysql;

import com.example.products.app.interfaces.IProductSaver;
import com.example.products.domain.entities.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlProductsSaver implements IProductSaver {
    @Override
    public void save(Product newProduct) {
        try {
            Connection connection = getConnection();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO products (id,name,price) VALUES (?,?,?)");

            statement.setString(1,newProduct.getId());
            statement.setString(2, newProduct.getName());
            statement.setDouble(3,newProduct.getPrice());

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Failed When saving :c");
        }

    }

    private Connection getConnection(){
        try{
            return DriverManager.getConnection("jbdc:mysql//localhost/caexample"
                    ,"epicuser",
                    "epicpassword");
        }catch (SQLException error){
            throw new RuntimeException("Failed Connection");
        }

    }
}
