package com.uts.rapid.clean.model.dao;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.uts.rapid.clean.model.Address;
import org.bson.Document;
import org.bson.types.ObjectId;

public class AddressDAO extends MongoDB {

    public AddressDAO() {
        super();
    }

    public Address findAddress(String addressId) {
        MongoCollection<Document> addresses = super.database.getCollection("Address");
        ObjectId addressObjId = new ObjectId(addressId);
        Document doc = addresses.find(eq("_id", addressObjId)).first();
        Address address = new Address(addressId, (String) doc.get("customer_id"), (String) doc.get("streetAddress"), (String) doc.get("suburb"), (String) doc.get("state"), (int) doc.get("postcode"));
        return address;
    }
}
