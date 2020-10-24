/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.Customer;
import com.uts.rapid.clean.model.Order;
import com.uts.rapid.clean.model.OrderAccepted;
import com.uts.rapid.clean.model.OrderCompleted;
import com.uts.rapid.clean.model.dao.AddressDAO;
import com.uts.rapid.clean.model.dao.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author trandamtrungthai
 */
public class ReOrderServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        String orderCategory = request.getParameter("orderCategory");
        String orderCategoryDesc = request.getParameter("orderCategoryDesc");
        double hourlyRate = Double.parseDouble(request.getParameter("hourlyRate"));
        String residentialType = request.getParameter("residentialType");
        String addressId = request.getParameter("addressId");
        
        Customer customer = (Customer) session.getAttribute("customer");
        
        OrderDAO orderDAO = (OrderDAO) session.getAttribute("orderDAO");
        
        String customerId = customer.getId();
        
        Date dateTime = new Date();
        
        OrderAccepted orderAccepted = null;
        Order order = null;
        OrderCompleted orderCompleted = null;
        
        ArrayList<String> orderIdList = orderDAO.getOrderList(customerId);
        
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
        
        //find orderid in orderCompleted
        String orderCompletedId = "";
        for (String orderId : orderIdList) {
            boolean checkOrderCompletedExist = orderDAO.checkOrderCompletedExist(orderId);
            if (checkOrderCompletedExist == true) {
                orderCompletedId = orderId;
                orderCompleted = orderDAO.findOrderCompleted(orderCompletedId);
//                System.out.println(orderCompletedId);
            } else {
                continue;
            }
        }
        
        if (orderAccepted == null && orderCompleted == null) { 
            orderDAO.addOrder(customerId, addressId, residentialType, hourlyRate, orderCategory, orderCategoryDesc, dateTime);
            request.getRequestDispatcher("orderload.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/OrderPayServlet").forward(request, response);
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
        processRequest(request, response);
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
