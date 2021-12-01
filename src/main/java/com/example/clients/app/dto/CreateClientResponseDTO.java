package com.example.clients.app.dto;

import com.example.clients.domain.entities.Client;

public class CreateClientResponseDTO {
    private String id;
    private String name;
    private String surname;
    private String email;

    public CreateClientResponseDTO(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.surname = client.getSurname();
        this.email = client.getEmail();
    }

    public String getEmail() {
        return email;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
