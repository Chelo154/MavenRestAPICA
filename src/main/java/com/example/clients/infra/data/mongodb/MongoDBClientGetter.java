package com.example.clients.infra.data.mongodb;

import com.example.clients.app.interfaces.ClientGetter;
import com.example.clients.domain.entities.Client;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class MongoDBClientGetter implements ClientGetter {

    private String uri = "mongodb+srv://epicuser:epicpassword@practicecluster.pswx4.mongodb.net/" +
            "caexample?retryWrites=true&w=majority";

    @Override
    public ArrayList<Client> getAllClients() {
        ArrayList<Client> clients = new ArrayList<>();
        try(MongoClient mongoClient = MongoClients.create(uri)){
            MongoDatabase database = mongoClient.getDatabase("caexample");
            MongoCollection collection = database.getCollection("clients");

        }

        return clients;
    }
}
