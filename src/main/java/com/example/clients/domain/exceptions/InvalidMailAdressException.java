package com.example.clients.domain.exceptions;

public class InvalidMailAdressException extends RuntimeException{

    public InvalidMailAdressException(String email){
        super(email + " is not a valid e-mail address");
    }
}
