package com.uts.rapid.clean.model.dao;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.uts.rapid.clean.model.Customer;
import java.io.Serializable;
import org.bson.Document;
import org.bson.types.ObjectId;

public class CustomerDAO implements Serializable {
    
    private MongoCollection<Document> customerCollection;
    
    public CustomerDAO(MongoDatabase database) {
        customerCollection = database.getCollection("Customer");
    }
    
    // Insert a customer document with the given paramters
    public void createCustomer(String firstName, String lastName, String email,
            String password, String phoneNumber) {
        customerCollection.insertOne(new Document("firstName", firstName)
                .append("lastName", lastName)
                .append("email", email)
                .append("password", password)
                .append("phoneNumber", phoneNumber));
    }
    
    // Find whether a customer document exists with the given email address
    public boolean hasCustomer(String email) {
        return customerCollection.find(eq("email", email)).first() != null;
    }
    
    // Find a customer document with the given email address and password, then return the customer object
    public Customer findCustomer(String email, String password) {
        Document document = customerCollection.find(and(eq("email", email), eq("password", password))).first();
        if (document != null) {
            return new Customer(document.get("_id").toString(), (String) document.get("firstName"),
                    (String) document.get("lastName"), (String) document.get("email"),
                    (String) document.get("password"), (String) document.get("phoneNumber"));
        }
        else {
            return null;
        }
    }
    
    // Delete a customer document with the given customer ID
    public void deleteCustomer(String customerId) {
        customerCollection.deleteOne(eq("_id", new ObjectId(customerId)));
    }
}
