package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.Customer;
import com.uts.rapid.clean.model.Ticket;
import com.uts.rapid.clean.model.dao.TicketDAO;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TicketCustomerServlet extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
         // Gets current session and DAO
        HttpSession session = request.getSession();
        TicketDAO ticketDAO = (TicketDAO) session.getAttribute("ticketDAO");
        Customer customer = (Customer) session.getAttribute("customer");
        
        // Gets parameters
        String customerId = customer.getId();
        
        // Sets the attribute to list a tickets in the Collection
        try {
            List<Ticket> allTickets = ticketDAO.filterTicketByCustomerId(customerId);
            session.setAttribute("listTickets", allTickets);
        } catch (Exception e) {
            System.out.println("No tickets!");
        }
        
        // Redirects to their ticketboard
        request.getRequestDispatcher("ticketboard.jsp").forward(request, response);
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
