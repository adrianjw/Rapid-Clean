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
    MongoCollection customerCollection;
    
    // Accessing collection via connection established in MongoDB
    public RatingDAO() {
        super();
        collection = super.database.getCollection("Rating");
        customerCollection = super.database.getCollection("Customer");
    }
    
    // List all ratings. 
    // Iterate through every document in the collection and convert them into
    // a Rating Object to be added to the return allRatings list.
    public ArrayList<Rating> viewAllRatings() {

        ArrayList<Rating> allRatings = new ArrayList<>();
        FindIterable<Document> cursor = collection.find();
        Iterator it = cursor.iterator();
            while (it.hasNext()) {
                Document document = (Document) it.next();
                ObjectId id = (ObjectId) document.get("_id");
                String customerId = (String) document.get("customer_id");
                String orderCompletedId = (String) document.get("orderCompleted_id");
                int rating = (int) document.get("rating");
                String comment = (String) document.get("comment");
                Date date = (Date) document.get("date");
                
                Rating rate = new Rating(id.toHexString(), customerId, orderCompletedId, rating, comment, date);
                allRatings.add(rate);
            }
        return allRatings;
    }
    
    // Create rating by passing a new Rating Object and converting it to a document
    public void createRating(Rating rating) {
        collection.insertOne(toDocument(rating));
    }

    // Filtering by rating.
    public ArrayList<Rating> sortByRating (String mode) {
        ArrayList<Rating> sorted = new ArrayList<>();
        return sorted;
    }
    
    public ArrayList<Rating> sortByDate (String mode) {
        ArrayList<Rating> sorted = new ArrayList<>();
        return sorted;
    }
    
    // Reusable method. Converts Rating object to Mongo Document
    public static final Document toDocument(Rating rating) {
        ObjectId id = new ObjectId(rating.getId());
        return new Document("_id", id)
                .append("customer_id", rating.getCustomerId())
                .append("orderCompleted_id", rating.getOrderCompletedId())
                .append("rating", rating.getRating())
                .append("comment", rating.getComment())
                .append("date", rating.getDate());
    }
    
    public void ratingByCleaner(String cleanerId) {
        ObjectId queryId = new ObjectId(cleanerId);
    } 
   
}