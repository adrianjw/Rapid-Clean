package com.uts.rapid.clean.model.dao;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.uts.rapid.clean.model.Address;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    public Address findAddressByAddressId(String address_id) {
        ObjectId addressObjId = new ObjectId(address_id);
        Document document = addressCollection.find(eq("_id", addressObjId)).first();
        if (document != null) {
            return new Address(address_id, (String) document.get("customer_id"),
                    (String) document.get("streetAddress"), (String) document.get("suburb"),
                    (String) document.get("state"), (int) document.get("postcode"));
        }
        else {
            return null;
        }
    }
    
    // Find address document(s) with the specified customer ID, then return an array list of address object(s)
    public List<Address> findAddressByCustomerId(String customer_id) {
        List<Document> addressDocuments = addressCollection.find(eq("customer_id", customer_id)).into(new ArrayList<>());
        List<Address> addressObjects = new ArrayList<>();
        for (Document document : addressDocuments) {
            addressObjects.add(new Address(document.get("_id").toString(), (String) document.get("customer_id"),
                    (String) document.get("streetAddress"), (String) document.get("suburb"),
                    (String) document.get("state"), (int) document.get("postcode")));
        }
        return addressObjects;
    }
    
    // Delete an address document with the specified address ID
    public void deleteAddress(String address_id) {
        ObjectId addressObjId = new ObjectId(address_id);
        addressCollection.deleteOne(eq("_id", addressObjId));
    }
}
