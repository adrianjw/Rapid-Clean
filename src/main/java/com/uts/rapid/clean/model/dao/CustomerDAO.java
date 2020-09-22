package com.uts.rapid.clean.model.dao;

import com.uts.rapid.clean.model.Customer;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class CustomerDAO extends MongoDB {
    
    private MongoCollection<Document> collection;
    
    public CustomerDAO() {
        super();
        collection = super.database.getCollection("Customer");
    }
    
    public void createCustomer(String firstName, String lastName, String email, String password, String phone) {
        Document document = new Document("firstName", firstName)
                .append("lastName", lastName)
                .append("email", email)
                .append("password", password)
                .append("phone", phone);
        collection.insertOne(document);
    }
}
