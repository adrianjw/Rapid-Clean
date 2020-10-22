package com.uts.rapid.clean.model.dao;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.uts.rapid.clean.model.Rating;
import com.uts.rapid.clean.model.Ticket;
import java.io.Serializable;
import java.util.*;
import org.bson.Document;
import org.bson.types.ObjectId;

public class TicketDAO implements Serializable {
    
    private MongoCollection<Document> ticketCollection;
    
    // Accessing collection via connection established in MongoDB
    public TicketDAO(MongoDatabase database) {
        ticketCollection = database.getCollection("Ticket");
    }
    
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
    
    public List<Ticket> filterByDepartment(String department) { 
        List<Ticket> allTickets = viewAllTickets();
        List<Ticket> filteredTickets = new LinkedList<>();
        for (Ticket ticket : allTickets) {
            if ( ticket.getDepartment().equals(department)) {
                filteredTickets.add(ticket);
            }
        }
        return filteredTickets;
    }
    
    public List<Ticket> orderByDate(String option) { 
        return new LinkedList<Ticket>();
    }
    
    public List<Ticket> orderByStatus(String option) { 
        return new LinkedList<Ticket>();
    }
    
    public List<Ticket> orderByPriority(String option) { 
        return new LinkedList<Ticket>();
    }
    
    public Ticket findTicket(String ticketId) {
        List<Ticket> allTickets = viewAllTickets();
        for (Ticket ticket : allTickets) {
            if (ticket.getId().equals(ticketId)) {
                return ticket;
            }
        }
        return null;
    }
    
    public void createTicket(Ticket ticket) {
        ticketCollection.insertOne(toDocument(ticket));
    }
    
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
