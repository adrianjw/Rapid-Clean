package com.uts.rapid.clean.model.dao;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;
import com.uts.rapid.clean.model.Address;
import org.bson.Document;
import org.bson.types.ObjectId;

public class AddressDAO {

    private MongoCollection<Document> addressCollection;
    
    public AddressDAO(MongoDatabase database) {
        addressCollection = database.getCollection("Address");
    }

    public Address findAddress(String addressId) {
        ObjectId addressObjId = new ObjectId(addressId);
        Document doc = addressCollection.find(eq("_id", addressObjId)).first();
        return new Address(addressId, (String) doc.get("customer_id"),
                (String) doc.get("streetAddress"), (String) doc.get("suburb"),
                (String) doc.get("state"), (int) doc.get("postcode"));
    }
}
