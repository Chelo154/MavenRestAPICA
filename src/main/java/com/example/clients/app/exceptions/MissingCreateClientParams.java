package com.example.clients.app.exceptions;

public class MissingCreateClientParams extends RuntimeException{
    public MissingCreateClientParams(String param){
        super(param+" was not given for creating a client");
    }
}
