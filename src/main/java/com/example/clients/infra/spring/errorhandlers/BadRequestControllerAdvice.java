package com.example.clients.infra.spring.errorhandlers;

import com.example.clients.app.exceptions.MissingCreateClientParams;
import com.example.clients.domain.exceptions.InvalidMailAdressException;
import com.example.clients.infra.spring.error.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BadRequestControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {MissingCreateClientParams.class, InvalidMailAdressException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request){
        ErrorMessage error = new ErrorMessage(ex);
        return handleExceptionInternal(ex,error,new HttpHeaders(), HttpStatus.BAD_REQUEST,request);
    }
}


