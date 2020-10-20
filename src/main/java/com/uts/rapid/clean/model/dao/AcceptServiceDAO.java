package com.uts.rapid.clean.model.dao;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;
import com.uts.rapid.clean.model.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class AcceptServiceDAO implements Serializable {

    private MongoCollection<Document> customerCollection;
    private MongoCollection<Document> cleanerCollection;
    private MongoCollection<Document> orderCollection;
    private MongoCollection<Document> orderAcceptedCollection;
    private MongoCollection<Document> orderRejectedCollection;
    private MongoCollection<Document> orderCompletedCollection;
    private MongoCollection<Document> addressCollection;

    // Build a connection with MongoDB Atlas
    public AcceptServiceDAO(MongoDatabase database) {
        customerCollection = database.getCollection("Customer");
        cleanerCollection = database.getCollection("Cleaner");
        orderCollection = database.getCollection("Order");
        orderAcceptedCollection = database.getCollection("OrderAccepted");
        orderRejectedCollection = database.getCollection("OrderRejected");
        orderCompletedCollection = database.getCollection("OrderCompleted");
        addressCollection = database.getCollection("Address");
    }

    // Insert to the RejectedOrder - for Cleaners (Reject Order button pressed)
    public void insertRejectOrder(String orderId, String cleanerId) {
        ObjectId orderObjId = new ObjectId(orderId);
        Document document = new Document("order_id", orderObjId)
                .append("cleaner_id", cleanerId);

        orderRejectedCollection.insertOne(document);
    }

    //Insert to the  Orders Accepted Collection - for Cleaners (Accept Order button pressed)
    public void insertAcceptOrder(String orderId, String cleanerId) {
        ObjectId orderObjId = new ObjectId(orderId);
        ObjectId cleanerObjId = new ObjectId(cleanerId);
        Document document = new Document("order_id", orderObjId)
                .append("cleaner_id", cleanerObjId);

        orderAcceptedCollection.insertOne(document);
    }

    // Insert to the Order Completed Collection - for Cleaners (Finish button pressed)
    public void insertCompletedOrder(String order_id, Date startTime, Date endTime,
            double workedHours, String cleaner_id) {
        Document document = new Document("order_id", order_id)
                .append("cleaner_id", cleaner_id)
                .append("startTime", startTime)
                .append("endTime", endTime)
                .append("workedHours", workedHours);

        orderCompletedCollection.insertOne(document);
    }

    // Returns the Order object to retrieve its details
    public Order order(String orderId) {
        ObjectId orderObjId = new ObjectId(orderId);
        Document doc = orderCollection.find(eq("_id", orderObjId)).first();
        Order order = new Order(orderId, (String) doc.get("customer_id"), (String) doc.get("address_id"),
                (String) doc.get("residentialType"), (double) doc.get("hourlyRate"),
                (String) doc.get("orderCategory"), (String) doc.get("orderCategoryDesc"),
                (Date) doc.get("dateTime"));
        return order;
    }
    
    // Get Address Details from Address ID
    public Address address(String addressId) {
        ObjectId addressObjId = new ObjectId(addressId);
        Document doc = addressCollection.find(eq("_id", addressObjId)).first();
        Address address = new Address(addressId, (String) doc.get("customer_id"), (String) doc.get("streetAddress"),
                (String) doc.get("suburb"), (String) doc.get("state"), (int) doc.get("postcode"));
        return address;
    }

    public String addressDets(String addressId) {
        ObjectId addressObjId = new ObjectId(addressId);
        Document doc = addressCollection.find(eq("_id", addressObjId)).first();
        Address address = new Address(addressId, (String) doc.get("customer_id"), (String) doc.get("streetAddress"),
                (String) doc.get("suburb"), (String) doc.get("state"), (int) doc.get("postcode"));
        return address.getFullAddress();
    }

    // Returns the customer object
    public Customer findCustomer(String customerId) {
        ObjectId customerObjId = new ObjectId(customerId);
        Document doc = customerCollection.find(eq("_id", customerObjId)).first();
        Customer customer = new Customer(customerId, (String) doc.get("firstName"), (String) doc.get("lastName"),
                (String) doc.get("email"), (String) doc.get("password"), (String) doc.get("phoneNumber"));
        return customer;
    }

    // Returns the cleaner object
    public Cleaner findCleaner(String cleanerId) {
        ObjectId cleanerObjId = new ObjectId(cleanerId);
        Document doc = cleanerCollection.find(eq("_id", cleanerObjId)).first();
        Cleaner cleaner = new Cleaner(cleanerId, (String) doc.get("firstName"), (String) doc.get("lastName"),
                (String) doc.get("email"), (String) doc.get("password"), (String) doc.get("phoneNumber"),
                (int) doc.get("bankBsbNumber"), (int) doc.get("bankAccountNumber"),
                (String) doc.get("bankAccountHolderName"));
        return cleaner;
    }
    
    // Find OrderCompleted Object
    public OrderCompleted findOrderCompleted(String orderId) {
        Document doc = orderCompletedCollection.find(eq("order_id", orderId)).first();
        ObjectId orderCompletedObjId = (ObjectId) doc.get("_id");
        String newOrderCompletedId = orderCompletedObjId.toString();
        OrderCompleted orderCompleted = new OrderCompleted(newOrderCompletedId, (String) doc.get("order_id"),
                (Date) doc.get("startTime"), (Date) doc.get("endTime"), (double) doc.get("workedHours"),
                (String) doc.get("cleaner_id"));
        return orderCompleted;
    }

    // List out the current orders which has not been Accepted (Does not exist in orderAccepted collection)
    public ArrayList<Order> orderList(String cleanerId) {
        boolean helper = false;
        Bson lookup = new Document("$lookup",
                new Document("from", "OrderAccepted")
                        .append("localField", "_id")
                        .append("foreignField", "order_id")
                        .append("as", "OrdersAccepted"));

        Bson lookup2 = new Document("$lookup",
                new Document("from", "OrderRejected")
                        .append("localField", "_id")
                        .append("foreignField", "order_id")
                        .append("as", "OrdersRejected"));

        List<Bson> filters = new ArrayList<>();
        filters.add(lookup);
        filters.add(lookup2);

        ArrayList<Document> orderList = orderCollection.aggregate(filters).into(new ArrayList<>());
        ArrayList<Order> table = new ArrayList();
        for (Document orders : orderList) {
            List<Document> list = (List<Document>) orders.get("OrdersAccepted");
            List<Document> listRejected = (List<Document>) orders.get("OrdersRejected");

            // if the particular order has not been accepted, i.e OrderAccepted is empty
            if (list.isEmpty()) {

                if (!listRejected.isEmpty()) {

                    for (Document rejectedCleaner : listRejected) {
                        ArrayList<String> cleanerList = new ArrayList();
                        String cleanerIdDB = (String) rejectedCleaner.get("cleaner_id");
                        cleanerList.add(cleanerIdDB);

                        // If the order has not been rejected by cleaner, i.e cleanerId exist in the OrderRejected Document (merged with Order) of a particular Order 
                        if (cleanerIdDB.equalsIgnoreCase(cleanerId)) {
                            helper = true;
                        }
                    }

                    if (!helper) {
                        ObjectId orderObjId = (ObjectId) orders.get("_id");
                        String newOrderId = orderObjId.toString();
                        Order order = new Order(newOrderId, (String) orders.get("customer_id"),
                                (String) orders.get("address_id"), (String) orders.get("residentialType"),
                                (double) orders.get("hourlyRate"), (String) orders.get("orderCategory"),
                                (String) orders.get("orderCategoryDesc"), (Date) orders.get("dateTime"));
                        table.add(order);
                    }
                }
                else {
                    ObjectId orderObjId = (ObjectId) orders.get("_id");
                    String newOrderId = orderObjId.toString();
                    Order order = new Order(newOrderId, (String) orders.get("customer_id"),
                            (String) orders.get("address_id"), (String) orders.get("residentialType"),
                            (double) orders.get("hourlyRate"), (String) orders.get("orderCategory"),
                            (String) orders.get("orderCategoryDesc"), (Date) orders.get("dateTime"));
                    table.add(order);
                }
            }
        }

        if (!table.isEmpty()) {
            return table;
        }
        else {
            return null;
        }
    }

    private void viewAllOrders() {
        ArrayList<Order> shipmentdetails = orderList("ASDASDAS");
        System.out.println("Saved Shipping Details:");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-30s %-20s %-20s \n", "Order ID", "Customer Name", "Address ID", "residentialType", "hourlyRate");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        shipmentdetails.stream().forEach((shipmentdetail) -> {
            Customer customer = findCustomer(shipmentdetail.getCustomer_id());
            Address address = address(shipmentdetail.getAddress_id());
            System.out.printf("%-10s %-20s %-30s %-20s %-20s \n", shipmentdetail.getId(),
                    customer.getFirstName(), shipmentdetail.getAddress_id(),
                    shipmentdetail.getResidentialType(), shipmentdetail.getOrderCategoryDesc());
            System.out.println(address.getFullAddress());
        });
        System.out.println();
    }

    public void displayOrderTest() {
        Bson lookup = new Document("$lookup",
                new Document("from", "OrderAccepted")
                        .append("localField", "_id")
                        .append("foreignField", "order_id")
                        .append("as", "Orders"));

        Bson lookup2 = new Document("$lookup",
                new Document("from", "OrderRejected")
                        .append("localField", "_id")
                        .append("foreignField", "order_id")
                        .append("as", "OrdersRejected"));

        List<Bson> filters = new ArrayList<>();
        filters.add(lookup);
        filters.add(lookup2);

        ArrayList<Document> test = orderCollection.aggregate(filters).into(new ArrayList<>());//.find(query).into(new ArrayList<>());
        for (Document orders : test) {
            System.out.println(orders);
            List<Document> list = (List<Document>) orders.get("Orders");
            if (list.size() > 0) {
                for (Document lister : list) {
                    System.out.println(lister.get("order_id"));
                }

                System.out.println();
                System.out.println("This is EMPTY");
            } else {
                System.out.println("THIS IS NOT EMPTY");
            }
        }
    }
}
