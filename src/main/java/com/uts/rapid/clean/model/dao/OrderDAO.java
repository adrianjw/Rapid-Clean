/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.rapid.clean.model.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.Date;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author trandamtrungthai
 */
public class OrderDAO extends MongoDB{
    
    private MongoCollection<Document> collection; 
            
    public OrderDAO() {
        super();
    }
   
    
    public void addOrder(String service, int price, String resident, String orderCategoryDesc, String dateTime) {
        collection = super.database.getCollection("Order");
        Document doc = new Document("orderCategory", service)
                .append("hourlyRate", price)
                .append("residentialType", resident)
                .append("orderCategoryDesc", orderCategoryDesc)
                .append("dateTime", dateTime);
        collection.insertOne(doc);
    }
    

     //get customerid using session in servlet 
    public String findAddressId(String customerId) {
        collection = super.database.getCollection("Address");        
        ObjectId customerObjId = new ObjectId(customerId);
        Document document = collection.find(eq("customer_id", customerObjId)).first(); 
        String addressId = (String) document.get("_id");
        return addressId;        
    }
}