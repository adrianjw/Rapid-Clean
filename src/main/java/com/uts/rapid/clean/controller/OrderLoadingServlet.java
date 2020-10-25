package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.Customer;
import com.uts.rapid.clean.model.OrderAccepted;
import com.uts.rapid.clean.model.dao.OrderDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderLoadingServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        String customerId = customer.getId();
        OrderDAO orderDAO = (OrderDAO) session.getAttribute("orderDAO");
        
        ArrayList<String> orderIdList = orderDAO.getOrderList(customerId);
        OrderAccepted orderAccepted = null;
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
        
        try {
            if (orderAccepted != null) { 
            request.getRequestDispatcher("/OrderPayServlet").forward(request, response);
            } else { 
                request.getRequestDispatcher("order-loading-screen.jsp").forward(request, response); 
            }
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
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
