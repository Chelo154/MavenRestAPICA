package com.example.clients.infra.data.array;

import com.example.clients.app.interfaces.ClientSaver;
import com.example.clients.domain.entities.Client;

import java.util.ArrayList;

public class ClientArray implements ClientSaver {

    private final ArrayList<Client> clients;

    public ClientArray(){
        clients = new ArrayList<>();
    }

    @Override
    public void save(Client client) {
        clients.add(client);
    }
}
