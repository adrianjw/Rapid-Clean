package com.uts.rapid.clean.model.dao;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
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
    
    // Insert an address document with the given paramters
    public void createAddress(String customerId, String streetAddress, String suburb, String state, int postcode) {
        addressCollection.insertOne(new Document("customer_id", customerId)
                .append("streetAddress", streetAddress)
                .append("suburb", suburb)
                .append("state", state)
                .append("postcode", postcode));
    }
    
    // Find whether an address document exists with the given parameters
    public boolean hasAddress(String customerId, String streetAddress, String suburb, String state, int postcode) {
        return addressCollection.find(and(eq("customer_id", customerId), eq("streetAddress", streetAddress),
                eq("suburb", suburb), eq("state", state), eq("postcode", postcode))).first() != null;
    }
    
    // Find an address document with the given address ID, then return the address object
    public Address findAddressByAddressId(String addressId) {
        ObjectId addressObjId = new ObjectId(addressId);
        Document document = addressCollection.find(eq("_id", addressObjId)).first();
        if (document != null) {
            return new Address(addressId, (String) document.get("customer_id"),
                    (String) document.get("streetAddress"), (String) document.get("suburb"),
                    (String) document.get("state"), (int) document.get("postcode"));
        }
        else {
            return null;
        }
    }
    
    // Find address document(s) with the given customer ID, then return an array list of address object(s)
    public List<Address> findAddressByCustomerId(String customerId) {
        List<Document> addressDocuments = addressCollection.find(eq("customer_id", customerId)).into(new ArrayList<>());
        List<Address> addressObjects = new ArrayList<>();
        for (Document document : addressDocuments) {
            addressObjects.add(new Address(document.get("_id").toString(), (String) document.get("customer_id"),
                    (String) document.get("streetAddress"), (String) document.get("suburb"),
                    (String) document.get("state"), (int) document.get("postcode")));
        }
        return addressObjects;
    }
    
    // Update an address document with the given address ID
    public void updateAddress(String addressId, String streetAddress, String suburb, String state, int postcode) {
        addressCollection.updateOne(eq("_id", new ObjectId(addressId)), combine(set("streetAddress", streetAddress),
                set("suburb", suburb), set("state", state), set("postcode", postcode)));
    }
    
    // Delete an address document with the given address ID
    public void deleteAddress(String addressId) {
        addressCollection.deleteOne(eq("_id", new ObjectId(addressId)));
    }
}
