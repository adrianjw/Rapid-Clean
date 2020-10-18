package com.uts.rapid.clean.model.dao;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;
import com.uts.rapid.clean.model.Address;
import java.io.Serializable;
import org.bson.Document;
import org.bson.types.ObjectId;

public class AddressDAO implements Serializable {

    private MongoCollection<Document> addressCollection;
    
    public AddressDAO(MongoDatabase database) {
        addressCollection = database.getCollection("Address");
    }
    
    // Insert an address document with the specified paramters
    public void createAddress(String customer_id, String streetAddress, String suburb, String state, int postcode) {
        Document document = new Document("customer_id", customer_id)
                .append("streetAddress", streetAddress)
                .append("suburb", suburb)
                .append("state", state)
                .append("postcode", postcode);
        addressCollection.insertOne(document);
    }
    
    // Find whether an address document exists with the specified parameters
    public boolean hasAddress(String customer_id, String streetAddress, String suburb, String state, int postcode) {
        return addressCollection.find(and(eq("customer_id", customer_id), eq("streetAddress", streetAddress),
                eq("suburb", suburb), eq("state", state), eq("postcode", postcode))).first() != null;
    }
    
    // Find an address document with the specified address ID, then return the address object
    public Address findAddress(String address_id) {
        ObjectId addressObjId = new ObjectId(address_id);
        Document document = addressCollection.find(eq("_id", addressObjId)).first();
        return new Address(address_id, (String) document.get("customer_id"),
                (String) document.get("streetAddress"), (String) document.get("suburb"),
                (String) document.get("state"), (int) document.get("postcode"));
    }
    
    // Delete an address document with the specified address ID
    public void deleteAddress(String id) {
        ObjectId address_id = new ObjectId(id);
        addressCollection.deleteOne(eq("_id", address_id));
    }
}
