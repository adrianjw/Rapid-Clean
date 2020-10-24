package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.*;
import com.uts.rapid.clean.model.dao.TicketDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TicketDeleteServlet extends HttpServlet {

      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         // Gets current session and DAO
        HttpSession session = request.getSession();
        TicketDAO ticketDAO = (TicketDAO) session.getAttribute("ticketDAO");
        
        // Gets parameters
        Customer customer = (Customer) session.getAttribute("customer");
        Cleaner cleaner = (Cleaner) session.getAttribute("cleaner");
        String ticketId = (String) request.getParameter("ticketId");
        
        // Deletes the ticket
        ticketDAO.deleteTicket(ticketId);
        
        // Re-directs to ticketborad depending on type of user logged in
        if ( customer != null ) {
            request.getRequestDispatcher("TicketCustomerServlet").forward(request, response);
        } else if ( cleaner != null ) {
            request.getRequestDispatcher("TicketCleanerServlet").forward(request, response);
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
