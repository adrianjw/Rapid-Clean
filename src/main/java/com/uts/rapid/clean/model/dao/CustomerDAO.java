package com.uts.rapid.clean.model.dao;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.uts.rapid.clean.model.Customer;

public class CustomerDAO extends MongoDB {
    
    private MongoCollection<Document> collection;
    
    public CustomerDAO() {
        super();
        collection = super.database.getCollection("Customer");
    }
    
    public void createCustomer(String firstName, String lastName, String email,
            String password, String phoneNumber) {
        Document document = new Document("firstName", firstName)
                .append("lastName", lastName)
                .append("email", email)
                .append("password", password)
                .append("phoneNumber", phoneNumber);
        collection.insertOne(document);
    }
    
    public boolean hasCustomer(String email) {
        return collection.find(eq("email", email)).first() != null;
    }
}
