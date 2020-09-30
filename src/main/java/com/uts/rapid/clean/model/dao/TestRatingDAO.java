package com.uts.rapid.clean.model.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.uts.rapid.clean.model.Rating;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

public class TestRatingDAO {
    
    MongoCollection collection;
    
    // Testing DAO methods for operations that cannot be manually tested
    public static void main(String[] args) {
        MongoDatabase database = new MongoDB().getDatabase();
        RatingDAO ratingDAO = new RatingDAO(database);
        ArrayList<Rating> allRatings = new ArrayList<>();
        
        System.out.println("Documents in rapidclean.rating collection: ");
        
        allRatings = ratingDAO.viewAllRatings();
        for (Rating rating : allRatings) {
            String id = rating.getId();
            String customerId = rating.getCustomerId();
            String orderCompletedId = rating.getOrderCompletedId();
            int stars = rating.getRating();
            String comment = rating.getComment();
            
            System.out.println(id+" "+customerId+" "+orderCompletedId+" "+stars+" "+comment);
        }
        System.out.println("----------------------------\nTotal Entries: "+allRatings.size());
        
        //System.out.println("\nFrom Order History ID: 5f6f2055d1a29368e580149f. Get Rating.");
        //String ratingId = ratingDAO.findRating("5f6f2055d1a29368e580149f");
        //System.out.println("Rating ID: "+ratingId);
        
        //System.out.println("Customer Name: " + ratingDAO.getCustomerName("5f6f2d6543c90043b7fa226e"));
    }
}
