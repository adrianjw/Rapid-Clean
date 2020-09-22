package com.uts.rapid.clean.model.dao;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.ConnectionString;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MongoDB {
    
    private MongoDatabase database;
    private MongoClient mongoClient;
    
    public MongoDB() {
        String uri = "mongodb+srv://asduser1:uts2020@cluster0.vldlh.mongodb.net/rapidclean?retryWrites=true&w=majority";
        mongoClient = MongoClients.create(uri);
        database = mongoClient.getDatabase("rapidclean");
    }
    
    public MongoCollection<Document> getCollection(String collection) {
        return database.getCollection(collection);
    }
}
