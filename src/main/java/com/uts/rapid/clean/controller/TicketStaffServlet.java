/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.Ticket;
import com.uts.rapid.clean.model.dao.TicketDAO;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sandy
 */
public class TicketStaffServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        TicketDAO ticketDAO = (TicketDAO) session.getAttribute("ticketDAO");
        
        String priority = (String) request.getParameter("priority-ft");
        String status = (String) request.getParameter("status-ft");
        
        System.out.println(status+ " " + priority);
        
        List<Ticket> filteredTickets = ticketDAO.viewAllTickets();
        
        if ( priority != null || status != null) {
            filteredTickets = new LinkedList<>();
            List<Ticket> filteredByPriority = ticketDAO.filterByPriority(priority);
            List<Ticket> filteredByStatus = ticketDAO.filterByStatus(status);
            
            filteredTickets.addAll(filteredByPriority);
            filteredTickets.addAll(filteredByStatus);
            
            if (filteredTickets != null) {
                session.setAttribute("listTickets", filteredTickets);
                request.getRequestDispatcher("ticketboard-staff.jsp").forward(request, response);
            } else {
                session.setAttribute("listTickets", filteredTickets);
                request.getRequestDispatcher("ticketboard-staff.jsp").forward(request, response);
            }
            
        } else if ( priority != null && priority.equals("na") ) {
            filteredTickets = new LinkedList<>();
            List<Ticket> filteredByPriority = ticketDAO.filterByPriority(priority);
            
        } else if ( priority == null || status == null ) {
            session.setAttribute("listTickets", filteredTickets);
            request.getRequestDispatcher("ticketboard-staff.jsp").forward(request, response);
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
