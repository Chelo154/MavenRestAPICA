package com.example.clients.app.service;

import com.example.clients.app.dto.CreateClientDTO;
import com.example.clients.app.dto.CreateClientResponseDTO;
import com.example.clients.app.interfaces.ClientSaver;
import com.example.clients.app.interfaces.ClientIdGenerator;
import com.example.clients.domain.entities.Client;

public class ClientCreatorService {
    private final ClientIdGenerator idGenerator;
    private final ClientSaver saver;

    public ClientCreatorService(ClientIdGenerator idGenerator, ClientSaver saver){
        this.idGenerator = idGenerator;
        this.saver = saver;
    }

    public CreateClientResponseDTO createClient(CreateClientDTO dto){
        String id = idGenerator.generateId();

        Client client = new Client(id,dto.getName(),dto.getSurname(),dto.getEmail());

        saver.save(client);

        return new CreateClientResponseDTO(client);
    }
}
