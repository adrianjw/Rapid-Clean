package com.uts.rapid.clean.model.dao;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.Block;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import org.bson.Document;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MongoDB {
    
    protected MongoDatabase database; 
    
    public MongoDB()
    {
        String uri = "mongodb+srv://asduser1:uts2020@cluster0.vldlh.mongodb.net/rapidclean?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(uri);
        database = mongoClient.getDatabase("rapidclean");
    }

}
