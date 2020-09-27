package com.uts.rapid.clean.model.dao;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;
import org.bson.Document;
import com.uts.rapid.clean.model.Customer;
import org.bson.types.ObjectId;

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
    
    public Customer findCustomer(String email, String password) {
        Document document = collection.find(and(eq("email", email), eq("password", password))).first();
        if (document != null) {
            return new Customer(document.get("_id").toString(), (String) document.get("firstName"),
                    (String) document.get("lastName"), (String) document.get("email"),
                    (String) document.get("password"), (String) document.get("phoneNumber"));
        }
        else {
            return null;
        }
    }
    
    public void deleteCustomer(String id) {
        ObjectId customerId = new ObjectId(id);
        collection.deleteOne(eq("_id", customerId));
    }
}
