package com.example.clients.infra.spring.rest;

import com.example.clients.app.controller.ClientCreatorController;
import com.example.clients.app.dto.CreateClientDTO;
import com.example.clients.app.dto.CreateClientResponseDTO;
import com.example.clients.app.service.ClientCreatorService;
import com.example.clients.infra.data.array.ClientArray;
import com.example.clients.infra.data.mongodb.MongoDBClientSaver;
import com.example.clients.infra.uuid.ClientUuidGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientCreatorRestController {
    private ClientCreatorController controller;

    public ClientCreatorRestController(){
        controller = new ClientCreatorController(
                new ClientCreatorService(
                        new ClientUuidGenerator(),
                        new MongoDBClientSaver()
                )
        );
    }

    @PostMapping(value = "/client",consumes = "application/json",produces = "application/json")
    public CreateClientResponseDTO createProduct(@RequestBody CreateClientDTO dto){
        return controller.createProduct(dto);
    }
}
