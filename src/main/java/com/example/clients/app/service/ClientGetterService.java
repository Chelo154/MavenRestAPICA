package com.example.clients.app.service;

import com.example.clients.app.dto.ClientsListResponseDTO;
import com.example.clients.app.interfaces.ClientGetter;
import com.example.clients.domain.entities.Client;

import java.util.ArrayList;

public class ClientGetterService {
    private ClientGetter getter;

    public ClientsListResponseDTO getAllClients(){
        ArrayList<Client> clients = getter.getAllClients();

        return new ClientsListResponseDTO(clients);
    }
}
