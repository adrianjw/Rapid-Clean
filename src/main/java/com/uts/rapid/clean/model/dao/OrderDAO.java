package com.uts.rapid.clean.model.dao;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Projections;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;
import com.uts.rapid.clean.model.Address;
import com.uts.rapid.clean.model.Order;
import com.uts.rapid.clean.model.OrderAccepted;
import com.uts.rapid.clean.model.OrderCompleted;
import java.util.ArrayList;
import java.util.Date;
import org.bson.Document;
import org.bson.types.ObjectId;

public class OrderDAO {
    
    private MongoCollection<Document> orderCollection;
    private MongoCollection<Document> orderAcceptedCollection;
    private MongoCollection<Document> orderCompletedCollection;
    private MongoCollection<Document> addressCollection;
            
    public OrderDAO(MongoDatabase database) {
        orderCollection = database.getCollection("Order");
        orderCollection = database.getCollection("Address");
    }
    
    public void addOrder(String customerId, String addressId, String residentialType,
            double hourlyRate, String orderCategory, String orderCategoryDesc, Date dateTime) {
        Document doc = new Document("customer_id", customerId)
                .append("address_id", addressId)
                .append("residentialType", residentialType)
                .append("hourlyRate", hourlyRate)
                .append("orderCategory", orderCategory)
                .append("orderCategoryDesc", orderCategoryDesc)
                .append("dateTime", dateTime);
        orderCollection.insertOne(doc);
    }
    
    public double findOrderRate(String orderId) {
        ObjectId orderObjId = new ObjectId(orderId);
        Document document = orderCollection.find(eq("_id", orderObjId)).first(); 
        double rate = (double) document.get("hourlyRate");
        return rate;
    }
    
    public void insertAddress(String customerId, String streetAddress, String suburb, String state, int postcode) {
        Document doc = new Document("customer_id", customerId)
                .append("streetAddress", streetAddress)
                .append("suburb", suburb)
                .append("state", state)
                .append("postcode", postcode);
        addressCollection.insertOne(doc);
    }
    
    // get addressid using session in servlet 
    public String findAddress(String customerId) {     
        Document document = addressCollection.find(eq("customer_id", customerId)).first(); 
        String addressId = document.get("_id").toString();
        return addressId;        
    }
    
    // get a list of orderids to check if they are in ordercompleted
    public ArrayList<String> getOrderList(String customerId) {
        ArrayList<String> orderIds = new ArrayList<String>();
        
        MongoCursor<Document> cursor = orderCollection.find(eq("customer_id", customerId))
                .projection(Projections.include("_id")).iterator();
        
        while (cursor.hasNext()) {
            Document document = cursor.next();
            orderIds.add(document.get("_id").toString());
        }
        
        return orderIds;
    }
    
    public ArrayList<String> findCleanerId(String orderId) {
        ArrayList<String> cleanerId = new ArrayList<String>();
        
        MongoCursor<Document> cursor = orderAcceptedCollection.find(eq("order_id", orderId)).iterator();

        while (cursor.hasNext()) {
            Document document = cursor.next();
            cleanerId.add(document.get("cleaner_id").toString());
        }
        
        return cleanerId;
    }
    
//    public Order order(String orderId) {
//        collection = super.database.getCollection("Order");
//        ObjectId orderObjId = new ObjectId(orderId);
//        Document doc = collection.find(eq("_id", orderObjId)).first();
//        Order order = new Order(orderId, (String) doc.get("customer_id"), (String) doc.get("address_id"), (String) doc.get("residentialType"), (double) doc.get("hourlyRate"), (String) doc.get("orderCategory"), (String) doc.get("orderCategoryDesc"), (Date) doc.get("dateTime"));
//        return order;
    
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
        Document doc = orderCompletedCollection.find(eq("order_id", orderId)).first();
   
        String newOrderCompletedId = doc.get("_id").toString();
        
        OrderCompleted orderCompleted = new OrderCompleted(newOrderCompletedId, (String) doc.get("order_id"),
                (Date) doc.get("startTime"), (Date) doc.get("endTime"), (double) doc.get("workedHours"),
                (String) doc.get("cleaner_id"));
        
        return orderCompleted;
    }
    
    public boolean checkOrderCompletedExist(String orderId) {
        Document doc = orderCompletedCollection.find(eq("order_id", orderId)).first();
        
        try {
            String newOrderCompletedId = doc.get("_id").toString(); 
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return false;
        }       
        
        return true;
    }
}
