package com.example.clients.infra.uuid;

import com.example.clients.app.interfaces.ClientIdGenerator;

import java.util.UUID;


public class ClientUuidGenerator implements ClientIdGenerator {
    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
