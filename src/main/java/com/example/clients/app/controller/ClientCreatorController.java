package com.example.clients.app.controller;

import com.example.clients.app.dto.CreateClientDTO;
import com.example.clients.app.dto.CreateClientResponseDTO;
import com.example.clients.app.service.ClientCreatorService;

public class ClientCreatorController {
    private final ClientCreatorService service;

    public ClientCreatorController(ClientCreatorService service){
        this.service = service;
    }

    public CreateClientResponseDTO createProduct(CreateClientDTO dto){
        dto.validate();

        return service.createClient(dto);
    }
}
