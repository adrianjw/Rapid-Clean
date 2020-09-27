/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.Customer;
import com.uts.rapid.clean.model.Order;
import com.uts.rapid.clean.model.dao.AddressDAO;
import com.uts.rapid.clean.model.dao.MongoDB;
import com.uts.rapid.clean.model.dao.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.bson.Document;

/**
 *
 * @author trandamtrungthai
 */
public class OrderFormServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
        HttpSession session = request.getSession();
        String orderCategory = request.getParameter("orderCategory");
        String orderCategoryDesc = request.getParameter("orderCategoryDesc");
        double hourlyRate = Double.parseDouble(request.getParameter("hourlyRate"));
        String residentialType = request.getParameter("residentialType");
        
        String streetAddress = request.getParameter("streetAddress");
        String suburb = request.getParameter("suburb");
        String state = request.getParameter("state");
        String postcode = request.getParameter("postcode");
        
        Customer customer = (Customer) session.getAttribute("customer");
              
        Date dateTime = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss z");
        
        String customerId = customer.getId();
        
        OrderDAO orderManager = new OrderDAO();
        
        orderManager.insertAddress(customerId, streetAddress, suburb, state, Integer.parseInt(postcode));
//        String dateTime = formatter.format(date);
//        Date newDateTime = formatter.parse(dateTime);
        
                
        
        String addressId = orderManager.findAddress(customerId);        
        
        orderManager.addOrder(customerId, addressId, residentialType, hourlyRate, orderCategory, orderCategoryDesc, dateTime);
        
        request.getRequestDispatcher("home.jsp").include(request, response);
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
