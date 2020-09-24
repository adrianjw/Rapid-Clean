package com.uts.rapid.clean.model.dao;
import com.mongodb.DB;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.ConnectionString;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import java.util.Arrays;
import java.util.Date;

public class MongoDB {
 
    protected MongoDatabase database;
    protected MongoClient mongoClient;
    
    public MongoDB() {
        String uri = "mongodb+srv://asduser1:uts2020@cluster0.vldlh.mongodb.net/rapidclean?retryWrites=true&w=majority";
        mongoClient = MongoClients.create();
        database = mongoClient.getDatabase("rapidclean");
//        MongoCollection<Document> collection = database.getCollection("Order");
//        Document document = new Document("customer_id", "507f1f77bcf86cd799439011")
//                                .append("residentialType", "apartment")
//                                .append("hourlyRate", 50)
//                                .append("orderCategory", "DELUXE")
//                                .append("orderCategoryDesc", "Floor Cleaning, Window Cleaning, Steam Carpet Cleaning, Kitchen Cleaning,  Bathroom Cleaning, Living Room Cleaning, Room Cleaning, Infection Control and Full House Sanitation.")
//                                .append("dateTime", new Date());
//        collection.insertOne(document);
    }
    
//    public static void main(String args[]) {
//        String uri = "mongodb+srv://asduser1:uts2020@cluster0.vldlh.mongodb.net/rapidclean?retryWrites=true&w=majority";
//        MongoClient mongoClient = MongoClients.create(uri);
//        MongoDatabase database = mongoClient.getDatabase("rapidclean");
//        MongoCollection<Document> collection = database.getCollection("Order");
//        Document document = new Document("customer_id", "507f1f77bcf86cd799439011")
//                                .append("address_id", "5f6bfea3ae6f6175c45ef247")
//                                .append("residentialType", "apartment")
//                                .append("hourlyRate", 50)
//                                .append("orderCategory", "DELUXE")
//                                .append("orderCategoryDesc", "Floor Cleaning, Window Cleaning, Steam Carpet Cleaning, Kitchen Cleaning,  Bathroom Cleaning, Living Room Cleaning, Room Cleaning, Infection Control and Full House Sanitation.")
//                                .append("dateTime", new Date());
//        collection.insertOne(document);
//    }
        
}
