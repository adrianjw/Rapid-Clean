/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.rapid.clean.model.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Projections;
import com.uts.rapid.clean.model.Address;
import com.uts.rapid.clean.model.Order;
import com.uts.rapid.clean.model.OrderAccepted;
import com.uts.rapid.clean.model.OrderCompleted;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
   
    
    public void addOrder(String customerId, String addressId, String residentialType, double hourlyRate, String orderCategory, String orderCategoryDesc, Date dateTime) {
        collection = super.database.getCollection("Order");
        Document doc = new Document("customer_id", customerId)
                .append("address_id", addressId)
                .append("residentialType", residentialType)
                .append("hourlyRate", hourlyRate)
                .append("orderCategory", orderCategory)
                .append("orderCategoryDesc", orderCategoryDesc)
                .append("dateTime", dateTime);
        collection.insertOne(doc);
    }
    
    public double findOrderRate(String orderId) {
        collection = super.database.getCollection("Order");
        ObjectId orderObjId = new ObjectId(orderId);
        Document document = collection.find(eq("_id", orderObjId)).first(); 
        double rate = (double) document.get("hourlyRate");
        return rate;
    }
    
     public void insertAddress(String customerId, String streetAddress, String suburb, String state, int postcode) {
        MongoCollection<Document> collection = super.database.getCollection("Address");
        Document doc = new Document("customer_id", customerId)
                .append("streetAddress", streetAddress)
                .append("suburb", suburb)
                .append("state", state)
                .append("postcode", postcode);
        collection.insertOne(doc);
    }
    

     //get addressid using session in servlet 
    public String findAddress(String customerId) {
        collection = super.database.getCollection("Address");        
        Document document = collection.find(eq("customer_id", customerId)).first(); 
        String addressId = document.get("_id").toString();
        return addressId;        
    }
    //get a list of orderids to check if they are in ordercompleted
    public ArrayList<String> getOrderList(String customerId) {
        collection = super.database.getCollection("Order");
        ArrayList<String> orderIds = new ArrayList<String>();
        
        MongoCursor<Document> cursor = collection.find(eq("customer_id", customerId)).projection(Projections.include("_id")).iterator();

        while (cursor.hasNext()) {
            Document document = cursor.next();
            orderIds.add(document.get("_id").toString());
        }
        
        return orderIds;
    }
    
    public ArrayList<String> findCleanerId(String orderId) {
        collection = super.database.getCollection("OrderAccepted");
        ArrayList<String> cleanerId = new ArrayList<String>();
        
        MongoCursor<Document> cursor = collection.find(eq("order_id", orderId)).iterator();

        while (cursor.hasNext()) {
            Document document = cursor.next();
            cleanerId.add(document.get("cleaner_id").toString());
        }
        
        return cleanerId;
    }
    
    
//    public String findOrderId(Date dateTime, String customerId) {
//        collection = super.database.getCollection("Order");
//        
//        BasicDBObject criteria = new BasicDBObject();
//        criteria.append("dateTime", dateTime);
//        criteria.append("customer_id", customerId);
//        
//        Document document = collection.find(criteria).first();
//        
//        String orderId = (String) document.get("_id");
//        return orderId;
//    }
    
    public OrderCompleted findOrderCompleted(String orderId) {
        collection = super.database.getCollection("OrderCompleted");
        
        Document doc = collection.find(eq("order_id", orderId)).first();
   
        String newOrderCompletedId = doc.get("_id").toString();
        
        OrderCompleted orderCompleted = new OrderCompleted(newOrderCompletedId, (String) doc.get("order_id"), (Date) doc.get("startTime"), (Date) doc.get("endTime"), (double) doc.get("workedHours"), (String) doc.get("cleaner_id"));
        
        return orderCompleted;
    }
    
    public boolean checkOrderCompletedExist(String orderId) {
        collection = super.database.getCollection("OrderCompleted");
        
        Document doc = collection.find(eq("order_id", orderId)).first();
        
        try {
            String newOrderCompletedId = doc.get("_id").toString();
            
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return false;
        }        
        return true;
    }
    
}
