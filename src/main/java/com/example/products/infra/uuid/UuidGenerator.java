package com.example.products.infra.uuid;

import com.example.products.app.interfaces.IdGenerator;
import java.util.UUID;

public class UuidGenerator implements IdGenerator {
    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
