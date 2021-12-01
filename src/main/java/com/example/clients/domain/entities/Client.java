package com.example.clients.domain.entities;

import com.example.clients.domain.valueobjects.Email;

public class Client {
    private String id;
    private String name;
    private String surname;
    private Email email;

    public Client(String id, String name, String surname, String  email){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = new Email(email);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email.getValue();
    }
}
