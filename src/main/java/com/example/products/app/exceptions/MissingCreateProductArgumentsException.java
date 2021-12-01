package com.example.products.app.exceptions;

public class MissingCreateProductArgumentsException extends RuntimeException{
    public MissingCreateProductArgumentsException(String className, String args){
        super(String.format("Some arguments are not given for creating the product, arguments are %s",args));
    }
}
