package com.uts.rapid.clean.model.dao;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.uts.rapid.clean.model.Cleaner;
import java.io.Serializable;

public class CleanerDAO implements Serializable {
    
    private MongoCollection<Document> cleanerCollection;
    
    public CleanerDAO(MongoDatabase database) {
        cleanerCollection = database.getCollection("Cleaner");
    }
    
    // Insert a cleaner document with the specified paramters
    public void createCleaner(String firstName, String lastName, String email,
            String password, String phoneNumber,int bankBsbNumber,
            int bankAccountNumber, String bankAccountHolderName) {
        Document document = new Document("firstName", firstName)
                .append("lastName", lastName)
                .append("email", email)
                .append("password", password)
                .append("phoneNumber", phoneNumber)
                .append("bankBsbNumber", bankBsbNumber)
                .append("bankAccountNumber", bankAccountNumber)
                .append("bankAccountHolderName", bankAccountHolderName);
        cleanerCollection.insertOne(document);
    }
    
    // Find whether a cleaner document exists with the specified email address
    public boolean hasCleaner(String email) {
        return cleanerCollection.find(eq("email", email)).first() != null;
    }
    
    // Find a cleaner document with the specified email address and password, then return the cleaner object
    public Cleaner findCleaner(String email, String password) {
        Document document = cleanerCollection.find(and(eq("email", email), eq("password", password))).first();
        if (document != null) {
            return new Cleaner(document.get("_id").toString(), (String) document.get("firstName"),
                    (String) document.get("lastName"), (String) document.get("email"),
                    (String) document.get("password"), (String) document.get("phoneNumber"),
                    (int) document.get("bankBsbNumber"), (int) document.get("bankAccountNumber"),
                    (String) document.get("bankAccountHolderName"));
        }
        else {
            return null;
        }
    }
    
    // Delete a cleaner document with the specified cleaner ID
    public void deleteCleaner(String id) {
        ObjectId cleaner_id = new ObjectId(id);
        cleanerCollection.deleteOne(eq("_id", cleaner_id));
    }
}
