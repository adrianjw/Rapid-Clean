package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.Cleaner;
import com.uts.rapid.clean.model.Ticket;
import com.uts.rapid.clean.model.dao.TicketDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TicketCleanerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Gets current session and DAO
        HttpSession session = request.getSession();
        TicketDAO ticketDAO = (TicketDAO) session.getAttribute("ticketDAO");
        Cleaner cleaner = (Cleaner) session.getAttribute("cleaner");
        
        // Gets parameters
        String cleanerId = cleaner.getId();
        
        // Sets the list to the tickets currently in the Ticket Collection
        try {
            List<Ticket> allTickets = ticketDAO.filterTicketByCustomerId(cleanerId);
            session.setAttribute("listTickets", allTickets);
        } catch (Exception e) {
            System.out.println("No tickets!");
        }
        
        // Redirects to Cleaners Ticketboard
        request.getRequestDispatcher("ticketboard-cleaner.jsp").forward(request, response);
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
