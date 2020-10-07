package com.uts.rapid.clean.model.dao;

import com.mongodb.client.MongoDatabase;
import com.uts.rapid.clean.model.Address;
import com.uts.rapid.clean.model.Customer;
import com.uts.rapid.clean.model.Order;
import java.util.ArrayList;

public class TestAcceptDAO {
    
    
    public static void main (String[] args){
        MongoDatabase database = new MongoDB().getDatabase();
        AcceptServiceDAO acceptServiceDAO = new AcceptServiceDAO(database);
        ArrayList<Order> orderList = acceptServiceDAO.orderList("5f6c5df38e81480d01878b09");
        if (orderList != null) {
            for (Order orderL : orderList) {
                Address address =  acceptServiceDAO.address(orderL.getAddress_id());
                Customer customer = acceptServiceDAO.findCustomer(orderL.getCustomer_id());

                System.out.println(orderL.getId());
            }
        }
        else {
            System.out.println("E<PTY :P ");
        }
    }
}
