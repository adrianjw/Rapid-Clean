package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.Customer;
import com.uts.rapid.clean.model.Order;
import com.uts.rapid.clean.model.OrderCompleted;
import com.uts.rapid.clean.model.dao.AcceptServiceDAO;
import com.uts.rapid.clean.model.dao.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderPayServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderPayServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderPayServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        String customerId = customer.getId();
        OrderDAO orderDAO = (OrderDAO) session.getAttribute("orderDAO");
        
        ArrayList<String> orderIdList = orderDAO.getOrderList(customerId);
        
        // String orderId = orderManager.findOrderId(dateTime, customerId);
        OrderCompleted orderCompleted = null;
        
        // check if orderId is in OrderCompleted collection
        String orderIdToUse = ""; //this is the orderId to put in parameter to find order
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
        
        double totalAmount = 0;
        // calculate total amount
        if (orderCompleted != null) {
            try {
                double workHours = orderCompleted.getWorkedHours();
                double rate = orderDAO.findOrderRate(orderIdToUse);
                totalAmount = workHours * rate;
                session.setAttribute("totalAmount", totalAmount);
            } catch (NullPointerException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
       
        // set sesssion for orderCompleted object
        if (orderCompleted != null) {
            session.setAttribute("orderCompleted", orderCompleted);
        } else {
            System.out.println("null");
        }
        
        try {
            session.setAttribute("totalAmount", totalAmount);
            request.getRequestDispatcher("orderpay.jsp").include(request, response);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
            request.getRequestDispatcher("orderpay.jsp").include(request, response);
        } 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
