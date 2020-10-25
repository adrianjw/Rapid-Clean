package com.uts.rapid.clean.model.dao;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.uts.rapid.clean.model.Staff;
import java.io.Serializable;
import org.bson.Document;

public class StaffDAO implements Serializable {
    
    private MongoCollection<Document> staffCollection;
    
    public StaffDAO(MongoDatabase database) {
        staffCollection = database.getCollection("Staff");
    }
    
    // Find a staff document with the given email address and password, then return the staff object
    public Staff findStaff(String email, String password) {
        Document document = staffCollection.find(and(eq("email", email), eq("password", password))).first();
        if (document != null) {
            return new Staff(document.get("_id").toString(), (String) document.get("firstName"),
                    (String) document.get("lastName"), (String) document.get("email"),
                    (String) document.get("password"));
        }
        else {
            return null;
        }
    }
}
