package com.uts.rapid.clean.model.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.uts.rapid.clean.model.Rating;
import java.sql.Timestamp;
import java.util.*;
import org.bson.Document;
import org.bson.types.ObjectId;

public class RatingDAO extends MongoDB {
   
    MongoCollection collection;
    
    // Accessing collection via connection established in MongoDB
    public RatingDAO() {
        super();
        collection = database.getCollection("Rating");
    }
    
    // List all ratings. 
    // Iterate through every document in the collection and convert them into
    // a Rating Object to be added to the return allRatings list.
    public ArrayList<Rating> viewAllRatings() {
        ArrayList<Rating> allRatings = new ArrayList<>();
        MongoCursor cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document document = (Document) cursor.next();
                ObjectId id = (ObjectId) document.get("_id");
                String customerId = (String) document.get("customer_id");
                String orderHistoryId = (String) document.get("orderHistoty_id");
                int rating = (int) document.get("rating");
                String comment = (String) document.get("comment");
                Date date = (Date) document.get("date");
                
                Rating rate = new Rating(id.toHexString(), customerId, orderHistoryId, rating, comment, date);
                allRatings.add(rate);
                return allRatings;
            }
        } finally { 
            cursor.close();
        }
        return null;
    }
    
    // Create rating by passing a new Rating Object and converting it to a document
    public void createRating(Rating rating) {
        collection.insertOne(toDocument(rating));
    }
    
    // Update rating by passing an updated Rating object
    public void updateRating (Rating rating) {
        String id = rating.getId();
        ObjectId queryId = new ObjectId(id);
        
        String customerId = rating.getCustomerId();
        String orderHistoryId = rating.getOrderHistoryId();
        int rate = rating.getRating();
        String comment = rating.getComment();
        Date date = new Date();
        
        Rating updatedRating = new Rating(id, customerId, orderHistoryId, rate, comment, date);
        
        collection.updateOne(eq("_id", queryId), toDocument(updatedRating));
    }
    
    // Delete Rating by passing an existing Rating's id
    public void deletRating (String id) {
        ObjectId queryId = new ObjectId(id);
        collection.deleteOne(eq("_id", queryId));
    }
    
    public ArrayList<Rating> filterRating (String criteria) {
        ArrayList<Rating> filtered = new ArrayList<>();
        return filtered;
    }
    
    // Filtering by rating.
    public ArrayList<Rating> sortByRating (String mode) {
        ArrayList<Rating> sorted = new ArrayList<>();
        Document sort = new Document("rating", -1);        
        if (mode.equals("asce")) {
            sort = new Document("rating", 1);
        } else {
            sort = new Document("rating", -1);
        }
        FindIterable<Document> sortedRatings = collection.find().sort(sort);
        MongoCursor<Document> cursor = sortedRatings.iterator();
        try {
            while (cursor.hasNext()) {
                Document document = (Document) cursor.next();
                ObjectId id = (ObjectId) document.get("_id");
                String customerId = (String) document.get("customer_id");
                String orderHistoryId = (String) document.get("orderHistoty_id");
                int rating = (int) document.get("rating");
                String comment = (String) document.get("comment");
                Date date = (Date) document.get("date");

                Rating rate = new Rating(id.toHexString(), customerId, orderHistoryId, rating, comment, date);
                sorted.add(rate);
            }
        } finally {
            cursor.close();
        }
        return sorted;
    }
    
    public ArrayList<Rating> sortByDate (String mode) {
        ArrayList<Rating> sorted = new ArrayList<>();
         Document sort = new Document("date", -1);        
        if (mode.equals("asce")) {
            sort = new Document("date", 1);
        } else {
            sort = new Document("date", -1);
        }
        FindIterable<Document> sortedRatings = collection.find().sort(sort);
        MongoCursor<Document> cursor = sortedRatings.iterator();
        try {
            while (cursor.hasNext()) {
                Document document = (Document) cursor.next();
                ObjectId id = (ObjectId) document.get("_id");
                String customerId = (String) document.get("customer_id");
                String orderHistoryId = (String) document.get("orderHistoty_id");
                int rating = (int) document.get("rating");
                String comment = (String) document.get("comment");
                Date date = (Date) document.get("date");

                Rating rate = new Rating(id.toHexString(), customerId, orderHistoryId, rating, comment, date);
                sorted.add(rate);
            }
        } finally {
            cursor.close();
        }
        return sorted;
    }
    
    
    // Reusable method. Converts Rating object to Mongo Document
    public static final Document toDocument(Rating rating) {
        ObjectId id = new ObjectId(rating.getId());
        return new Document("_id", id)
                .append("customer_id", rating.getCustomerId())
                .append("orderHistory_id", rating.getOrderHistoryId())
                .append("rating", rating.getRating())
                .append("comment", rating.getComment())
                .append("date", rating.getDate());
    }
   
}