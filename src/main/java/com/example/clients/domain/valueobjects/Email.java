package com.example.clients.domain.valueobjects;

import com.example.clients.domain.exceptions.InvalidMailAdressException;

import java.util.regex.Pattern;

public class Email {
    private String value;

    private final Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public Email(String email){
        validateEmail(email);

        this.value = email;
    }

    private void validateEmail(String email){
        if(!EMAIL_REGEX.matcher(email).matches()) throw new InvalidMailAdressException(email);
    }

    public String getAdrress(){
        return  this.value.split("@")[0];
    }

    public String getMailService(){
        return value.split("@")[1].split("\\.")[0];
    }

    public String getDomain(){
        return value.split("@")[1];
    }

    public void update(String newEmail){
        validateEmail(newEmail);

        this.value = newEmail;
    }

    public String getValue() {
        return value;
    }
}
