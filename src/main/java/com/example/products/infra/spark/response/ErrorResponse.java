package com.example.products.infra.spark.response;

public class ErrorResponse {
    private String errorType;

    private String message;

    public ErrorResponse(Exception exception){
        this.errorType = exception.getClass().getSimpleName();

        this.message = exception.getMessage();
    }

    public String getErrorType() {
        return errorType;
    }

    public String getMessage() {
        return message;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
