package com.uts.rapid.clean.model.dao;

import com.mongodb.*;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.uts.rapid.clean.model.Ticket;
import java.io.Serializable;
import java.util.*;
import org.bson.Document;
import org.bson.types.ObjectId;

public class TicketDAO implements Serializable {
    
    // private members
    private MongoCollection<Document> ticketCollection;
    
    // Accessing collection via connection established in MongoDB
    public TicketDAO(MongoDatabase database) {
        ticketCollection = database.getCollection("Ticket");
    }
    
    // Stores all tickets converted documents in an accessible list
    public List<Ticket> viewAllTickets() {
        List<Ticket> allTickets = new LinkedList<>();
        
        FindIterable<Document> cursor = ticketCollection.find();
        Iterator it = cursor.iterator();
        while(it.hasNext()) {
            Document document = (Document) it.next();
            ObjectId id = (ObjectId) document.get("_id");
            String customerId = (String) document.get("customer_id");
            String priority = (String) document.get("priority");
            String status = (String) document.get("status");
            String subject = (String) document.get("subject");
            String department = (String) document.get("department");
            String comment = (String) document.get("comment");
            Date date = (Date) document.get("date");
            
            Ticket ticket = new Ticket(id.toHexString(), customerId, priority, status, subject, department, comment, date);
            allTickets.add(ticket);
        }
        
        return allTickets;
    }
    
    // Stores all tickets filed by a user in a list
    public List<Ticket> filterTicketByCustomerId(String custId) {
        List<Ticket> allTickets = viewAllTickets();
        List<Ticket> filteredTickets = new LinkedList<>();
        for (Ticket ticket : allTickets) {
            if ( ticket.getCustomerId().equals(custId)) {
                filteredTickets.add(ticket);
            }
        }
        return filteredTickets;
    }
    
    // Stores all tickets whose priority matches the given a priority parameter in a list
    public List<Ticket> filterByPriority(String priority) {
        List<Ticket> allTickets = viewAllTickets();
        List<Ticket> filteredTickets = new LinkedList<>();
        for (Ticket ticket : allTickets) {
            if ( ticket.getPriority().equals(priority)) {
                filteredTickets.add(ticket);
            }
        }
        return filteredTickets;
    }
    
    // Stores all tickets whose priority matches the given a status parameter in a list
    public List<Ticket> filterByStatus(String status) { 
        List<Ticket> allTickets = viewAllTickets();
        List<Ticket> filteredTickets = new LinkedList<>();
        for (Ticket ticket : allTickets) {
            if ( ticket.getStatus().equals(status)) {
                filteredTickets.add(ticket);
            }
        }
        return filteredTickets;
    }
    
    // Returns a ticket object whose id matches the given id parameter
    public Ticket findTicket(String ticketId) {
        List<Ticket> allTickets = viewAllTickets();
        for (Ticket ticket : allTickets) {
            if (ticket.getId().equals(ticketId)) {
                return ticket;
            }
        }
        return null;
    }
    
    // Updates a ticket's status and priority by it's id with the given parameters.
    public void updateTicket(String id, String status, String priority) {
        ObjectId updateId = new ObjectId(id);
        Document query = new Document("_id", updateId);
        Document update = new Document();
        update.put("$set", new Document("status", status).append("priority", priority));
        
        ticketCollection.updateOne(query, update);
    }
    
    // Creates a new ticket. Adds to the collection
    public void createTicket(Ticket ticket) {
        ticketCollection.insertOne(toDocument(ticket));
    }
    
    // Deletes a Ticket. Removes from collection
    public void deleteTicket(String ticketId) {
        ObjectId filter = new ObjectId(ticketId);
        ticketCollection.deleteOne(eq("_id", filter));
    }
    
     // Reusable method. Converts Rating object to Mongo Document
    public static final Document toDocument(Ticket ticket) {
        ObjectId id = new ObjectId(ticket.getId());
        return new Document("_id", id)
                .append("customer_id", ticket.getCustomerId())
                .append("priority", ticket.getPriority())
                .append("status", ticket.getStatus())
                .append("subject", ticket.getSubject())
                .append("department", ticket.getDepartment())
                .append("comment", ticket.getComment())
                .append("date", ticket.getDate());
    }
}
