package com.uts.rapid.clean.model.dao;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDB {
    
    private MongoDatabase database;
    
    public MongoDB() {
        String uri = "mongodb+srv://asduser1:uts2020@cluster0.vldlh.mongodb.net/rapidclean?retryWrites=true&w=majority";
        database = MongoClients.create(uri).getDatabase("rapidclean");
    }
    
    public MongoDatabase getDatabase() {
        return database;
    }
}
