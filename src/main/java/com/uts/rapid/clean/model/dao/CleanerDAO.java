package com.uts.rapid.clean.model.dao;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.uts.rapid.clean.model.Cleaner;

public class CleanerDAO extends MongoDB {
    
    private MongoCollection<Document> collection;
    
    public CleanerDAO() {
        super();
        collection = super.database.getCollection("Cleaner");
    }
    
    public void createCleaner(String firstName, String lastName, String email,
            String password, String phoneNumber,String bankBsbNumber,
            String bankAccountNumber, String bankAccountHolderName) {
        Document document = new Document("firstName", firstName)
                .append("lastName", lastName)
                .append("email", email)
                .append("password", password)
                .append("phoneNumber", phoneNumber)
                .append("bankBsbNumber", bankBsbNumber)
                .append("bankAccountNumber", bankAccountNumber)
                .append("bankAccountHolderName", bankAccountHolderName);
        collection.insertOne(document);
    }
    
    public boolean hasCleaner(String email) {
        return collection.find(eq("email", email)).first() != null;
    }
}
