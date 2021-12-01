package com.example.clients.infra.data.mongodb;

import com.example.clients.app.interfaces.ClientSaver;
import com.example.clients.domain.entities.Client;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

public class MongoDBClientSaver implements ClientSaver {

    private final String uri = "mongodb+srv://epicuser:epicpassword@practicecluster.pswx4.mongodb.net/caexample?retryWrites=true&w=majority";

    @Override
    public void save(Client client) {

        try(MongoClient mongoClient = MongoClients.create(uri)){
            MongoDatabase database = mongoClient.getDatabase("caexample");
            MongoCollection<Document> clients = database.getCollection("clients");

            InsertOneResult result = clients.insertOne(new Document()
                    .append("_id",client.getId())
                    .append("name",client.getName())
                    .append("surname",client.getSurname())
                    .append("email",client.getEmail()));

        }catch (Exception error){
            throw new RuntimeException("Failed connection to Mongo");
        }

    }
}
