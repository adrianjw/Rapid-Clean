/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.rapid.clean.model.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Bryan Guntoro
 */
public class PaymentDetailsDAO {

    private MongoCollection<Document> customerCollection;
    private MongoCollection<Document> paymentDetailsCollection;

    // Build a connection with MongoDB Atlas
    public PaymentDetailsDAO(MongoDatabase database) {
        customerCollection = database.getCollection("Customer");
        paymentDetailsCollection = database.getCollection("PaymentDets");

    }

    // Create a Payment Detail
    public void createPaymentDetail()
    {
    }
    
    // Update Payment Detail
    public void updatePaymentDetail(String paymentDetail_id)
    {
        
    }
    
    // View all Payment Details
    public void viewPaymentDetail(String customer_id)
    {
        
    }
    
    // Delete Payment Detail
    public void deletePaymentDetail(String paymentDetail_id)
    {
        
    }
}
