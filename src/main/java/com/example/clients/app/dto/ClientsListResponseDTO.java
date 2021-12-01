package com.example.clients.app.dto;

import com.example.clients.domain.entities.Client;

import java.util.ArrayList;

public class ClientsListResponseDTO {
    private final ArrayList<CreateClientResponseDTO> clients;

    public ClientsListResponseDTO(ArrayList<Client> clients){
        this.clients = new ArrayList<>();
        clients.forEach(client -> this.clients.add(new CreateClientResponseDTO(client)));
    }

    public ArrayList<CreateClientResponseDTO> getClients() {
        return clients;
    }
}
