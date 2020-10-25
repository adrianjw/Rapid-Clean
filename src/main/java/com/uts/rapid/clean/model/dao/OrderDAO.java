package com.uts.rapid.clean.model.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.uts.rapid.clean.model.Address;
import com.uts.rapid.clean.model.Cleaner;
import com.uts.rapid.clean.model.Order;
import com.uts.rapid.clean.model.OrderAccepted;
import com.uts.rapid.clean.model.OrderCompleted;
import com.uts.rapid.clean.model.OrderHistory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

public class OrderDAO implements Serializable {
    
    private MongoCollection<Document> orderCollection;
    private MongoCollection<Document> orderAcceptedCollection;
    private MongoCollection<Document> orderCompletedCollection;
    private MongoCollection<Document> addressCollection;
    private MongoCollection<Document> cleanerCollection;
            
    public OrderDAO(MongoDatabase database) {
        orderCollection = database.getCollection("Order");
        addressCollection = database.getCollection("Address");
        orderCompletedCollection = database.getCollection("OrderCompleted");
        orderAcceptedCollection = database.getCollection("OrderAccepted");       
        cleanerCollection = database.getCollection("Cleaner");
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
    
    public void insertAddress(String customerId, String streetAddress, String suburb, String state, int postcode) {
        Document doc = new Document("customer_id", customerId)
                .append("streetAddress", streetAddress)
                .append("suburb", suburb)
                .append("state", state)
                .append("postcode", postcode);
        addressCollection.insertOne(doc);
    }
    
    // get addressid using customerId 
    public String findAddressId(String customerId) {     
//        Document document = addressCollection.find(eq("customer_id", customerId)).sort(); 
        FindIterable<Document> cursor = addressCollection.find(eq("customer_id", customerId)).sort(new Document("_id", -1));
        MongoCursor<Document> iterator = cursor.iterator();
        Document doc = iterator.next();
        String addressId = doc.get("_id").toString();

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
    
    public Order order(String orderId) {
        ObjectId orderObjId = new ObjectId(orderId);
        Document doc = orderCollection.find(eq("_id", orderObjId)).first();
        Order order = new Order(orderId, (String) doc.get("customer_id"), (String) doc.get("address_id"), (String) doc.get("residentialType"), (double) doc.get("hourlyRate"), (String) doc.get("orderCategory"), (String) doc.get("orderCategoryDesc"), (Date) doc.get("dateTime"));
        return order;
    }
    
    public ArrayList<Order> findOrder(String customerId) {
        ArrayList<Order> orders = new ArrayList<Order>();
        MongoCursor<Document> cursor = orderCollection.find(eq("customer_id", customerId)).iterator();
        
        while (cursor.hasNext()) {
            Document doc = cursor.next();
//            ObjectId orderObjId = (ObjectId) doc.get("_id");
            String orderId = doc.get("_id").toString();
            Order order = new Order(orderId, (String) doc.get("customer_id"), (String) doc.get("address_id"), (String) doc.get("residentialType"), (double) doc.get("hourlyRate"), (String) doc.get("orderCategory"), (String) doc.get("orderCategoryDesc"), (Date) doc.get("dateTime"));
            orders.add(order);
        }
        return orders;
    }
    
    public OrderCompleted findOrderCompleted(String orderId) {
        Document doc = orderCompletedCollection.find(eq("order_id", orderId)).first();
   
        String newOrderCompletedId = doc.get("_id").toString();
        
        OrderCompleted orderCompleted = new OrderCompleted(newOrderCompletedId, (String) doc.get("order_id"), (Date) doc.get("startTime"), (Date) doc.get("endTime"), (double) doc.get("workedHours"), (String) doc.get("cleaner_id")); 
        
        return orderCompleted;
    }
    
    //check a list of orderids if they exist in orderCompleted collection
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
    
    //find orderId in orderAccepted and return orderAccepted
    public OrderAccepted findOrderAccepted(String orderId) {
        ObjectId orderObjId = new ObjectId(orderId);
        Document doc = orderAcceptedCollection.find(eq("order_id", orderObjId)).first();
   
        String newOrderAcceptedId = doc.get("_id").toString();
        String cleanerId = doc.get("cleaner_id").toString(); //get customerId to convert to ObjId
        ObjectId cleanerObjId = new ObjectId(cleanerId);
        OrderAccepted orderAccepted = new OrderAccepted(newOrderAcceptedId, cleanerObjId, orderObjId);
        
        return orderAccepted;
    }
    
    public boolean checkOrderAcceptedExist(String orderId) {
        ObjectId orderObjId = new ObjectId(orderId);
        Document doc = orderAcceptedCollection.find(eq("order_id", orderObjId)).first();
        
        try {
            String newOrderAcceptedId = doc.get("_id").toString(); 
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return false;
        }       
        
        return true;
    }
    
    public Cleaner findCleaner(String cleanerId) {
        ObjectId cleanerObjId = new ObjectId(cleanerId);
        Document doc = cleanerCollection.find(eq("_id", cleanerId)).first();
        
        Cleaner cleaner = new Cleaner(cleanerId, (String) doc.get("firstName"), (String) doc.get("lastName"), (String) doc.get("email"), (String) doc.get("password"), (String) doc.get("phoneNumber"), (int) doc.get("bankBsbNumber"), (int) doc.get("bankAccountNumber"), (String) doc.get("bankAccountHolderName"));
        
        return cleaner;
    }
    
    public List<Order> findAndSortOrder(String customerId) {
        List<Order> listOfAscendingOrders = new ArrayList<Order>();
        FindIterable<Document> cursor = orderCollection.find(eq("customer_id", customerId)).sort(Sorts.descending("dateTime"));
        
        MongoCursor<Document> iterator = cursor.iterator();
        while(iterator.hasNext()) {
            Document doc = iterator.next();
            String orderId = doc.get("_id").toString();
            Order order = new Order(orderId, (String) doc.get("customer_id"), (String) doc.get("address_id"), (String) doc.get("residentialType"), (double) doc.get("hourlyRate"), (String) doc.get("orderCategory"), (String) doc.get("orderCategoryDesc"), (Date) doc.get("dateTime"));
            listOfAscendingOrders.add(order);
        }
        return listOfAscendingOrders;
    }
    
}
