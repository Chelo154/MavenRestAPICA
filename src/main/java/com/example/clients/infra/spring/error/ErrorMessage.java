package com.example.clients.infra.spring.error;

public class ErrorMessage {
    private String type;
    private String message;

    public ErrorMessage(Exception error){
        this.type = error.getClass().getSimpleName();
        this.message = error.getMessage();
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }
}
