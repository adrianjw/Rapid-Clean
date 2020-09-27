/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author trandamtrungthai
 */
public class OrderPayServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        String customerId = customer.getId();
        
        OrderDAO orderManager = new OrderDAO();
        
        ArrayList<String> orderIdList = orderManager.getOrderList(customerId);
        
//        String orderId = orderManager.findOrderId(dateTime, customerId);
        OrderCompleted orderCompleted = null;
        
        //check if orderId is in OrderCompleted collection
        String orderIdToUse = ""; //this is the orderId to put in parameter to find order
        for (String orderId : orderIdList) {
            boolean checkOrderCompletedExist = orderManager.checkOrderCompletedExist(orderId);
            if (checkOrderCompletedExist == true) {
                orderIdToUse = orderId;
            } else {
                continue;
            }
        }
        
        //find order in OrderCompleted collection
        try {
            orderCompleted = orderManager.findOrderCompleted(orderIdToUse);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }    
        
        double totalAmount = 0;
//        calculate total amount
        if (orderCompleted != null) {
            try {
                double workHours = orderCompleted.getWorkedHours();
                double rate = orderManager.findOrderRate(orderIdToUse);
                totalAmount = workHours * rate;
                session.setAttribute("totalAmount", totalAmount);
            } catch (NullPointerException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
       
        //set sesssion for orderCompleted object
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}