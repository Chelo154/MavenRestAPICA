package com.example.clients.app.controller;

import com.example.clients.app.dto.ClientsListResponseDTO;
import com.example.clients.app.service.ClientGetterService;

public class ClientGetterController {

    private ClientGetterService service;

    public ClientsListResponseDTO getAllClients() {return service.getAllClients();}
}
