package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.Customer;
import com.uts.rapid.clean.model.Order;
import com.uts.rapid.clean.model.OrderAccepted;
import com.uts.rapid.clean.model.OrderCompleted;
import com.uts.rapid.clean.model.dao.OrderDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderPayServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        String customerId = customer.getId();
        OrderDAO orderDAO = (OrderDAO) session.getAttribute("orderDAO");
        
        ArrayList<String> orderIdList = orderDAO.getOrderList(customerId);
        
        OrderAccepted orderAccepted = null;
        OrderCompleted orderCompleted = null;
        Order order = null;
        
        for (String orderId : orderIdList) {
            System.out.print(orderId);
        }
        
        //find orderid in orderAccepted
        String orderAcceptedId = ""; //this is the orderId to put in parameter to find order
        for (String orderId : orderIdList) {
            boolean checkOrderAcceptedExist = orderDAO.checkOrderAcceptedExist(orderId);
            if (checkOrderAcceptedExist == true) {
                orderAcceptedId = orderId;
                orderAccepted = orderDAO.findOrderAccepted(orderAcceptedId);
            } else {
                continue;
            }
        }
        
        // check if orderId is in OrderCompleted collection
        String orderIdToUse = null; //this is the orderId to put in parameter to find order
        for (String orderId : orderIdList) {
            boolean checkOrderCompletedExist = orderDAO.checkOrderCompletedExist(orderId);
            if (checkOrderCompletedExist == true) {
                orderIdToUse = orderId;
            } else {
                continue;
            }
        }
                
        // find order in OrderCompleted collection
        try {
            orderCompleted = orderDAO.findOrderCompleted(orderIdToUse);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }    
       
        // set sesssion for orderCompleted and order object
        if (orderAccepted != null) {
            order = orderDAO.order(orderAcceptedId);
            session.setAttribute("orderAccepted", orderAccepted);
            session.setAttribute("orderCompleted", orderCompleted);
            session.setAttribute("order", order);
        } else if (orderCompleted != null) {
            session.setAttribute("orderAccepted", orderAccepted);
            session.setAttribute("orderCompleted", orderCompleted);
        } else {
            session.setAttribute("orderAccepted", orderAccepted);
            session.setAttribute("orderCompleted", orderCompleted);
            session.setAttribute("order", order);
        }
                        
        try {
            request.getRequestDispatcher("order-pay.jsp").forward(request, response);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
            request.getRequestDispatcher("order-pay.jsp").include(request, response);
        } 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
