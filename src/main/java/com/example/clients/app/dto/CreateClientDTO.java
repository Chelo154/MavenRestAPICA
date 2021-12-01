package com.example.clients.app.dto;

import com.example.clients.app.exceptions.MissingCreateClientParams;

public class CreateClientDTO {
    private String name;
    private String surname;
    private String email;

    public CreateClientDTO(){}

    public CreateClientDTO(String name, String surname, String email){
        this.email = email;
        this.name = name;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void validate(){
        if(name == null) throw new MissingCreateClientParams("name");
        if(surname == null) throw new MissingCreateClientParams("surname");
        if(email == null) throw new MissingCreateClientParams("email");
    }
}
