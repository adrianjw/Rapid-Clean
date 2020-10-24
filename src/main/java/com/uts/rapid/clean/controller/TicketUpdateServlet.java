package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.dao.TicketDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TicketUpdateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Gets current session and DAO layer
        HttpSession session = request.getSession();
        TicketDAO ticketDAO = (TicketDAO) session.getAttribute("ticketDAO");
        
        // Gets parameters
        String status = (String) request.getParameter("status-fd");
        String priority = (String) request.getParameter("priority-fd");
        String ticketId = (String) request.getParameter("ticketId");
        
        // Test: Print the parameter values
        System.out.println(status + " " + priority);
        
        // Update the document
        ticketDAO.updateTicket(ticketId, status, priority);
        
        // Redirects to the staff ticketboard
        request.getRequestDispatcher("TicketStaffServlet").forward(request, response);
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
