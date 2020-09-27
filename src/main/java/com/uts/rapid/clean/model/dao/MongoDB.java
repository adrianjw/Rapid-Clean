package com.uts.rapid.clean.model.dao;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDB {
    
    protected MongoDatabase database;
    protected MongoClient mongoClient;
    
    public MongoDB() {
        String uri = "mongodb+srv://asduser1:uts2020@cluster0.vldlh.mongodb.net/rapidclean?retryWrites=true&w=majority";
        mongoClient = MongoClients.create();
        database = mongoClient.getDatabase("rapidclean");
    }
}
