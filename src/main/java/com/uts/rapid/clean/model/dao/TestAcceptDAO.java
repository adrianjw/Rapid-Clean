/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.rapid.clean.model.dao;

import com.uts.rapid.clean.model.Address;
import com.uts.rapid.clean.model.Customer;
import com.uts.rapid.clean.model.Order;
import java.util.ArrayList;

/**
 *
 * @author Bryan Guntoro
 */
public class TestAcceptDAO {
    
    
    public static void main (String[] args){
        AcceptServiceDAO test1 = new AcceptServiceDAO();
        ArrayList<Order> orderList = test1.orderList("5f69e1da84ebe990acfef9d6");
        if (orderList != null)
        {
        for (Order orderL : orderList)
        {
            Address address =  test1.address(orderL.getAddress_id());
            Customer customer = test1.findCustomer(orderL.getCustomer_id());
            
            System.out.println(orderL.getId());
        }
        }
        else 
        {
            System.out.println("E<PTY :P ");
        }
    }
}

