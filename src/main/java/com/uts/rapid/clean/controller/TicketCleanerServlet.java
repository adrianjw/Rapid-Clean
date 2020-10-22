/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.Cleaner;
import com.uts.rapid.clean.model.Ticket;
import com.uts.rapid.clean.model.dao.TicketDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
public class TicketCleanerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        TicketDAO ticketDAO = (TicketDAO) session.getAttribute("ticketDAO");
        Cleaner cleaner = (Cleaner) session.getAttribute("cleaner");
        
        String cleanerId = cleaner.getId();
        
        try {
            List<Ticket> allTickets = ticketDAO.filterTicketByCustomerId(cleanerId);
            session.setAttribute("listTickets", allTickets);
        } catch (Exception e) {
            System.out.println("No tickets!");
        }

        request.getRequestDispatcher("ticketboard-cleaner.jsp").forward(request, response);
    }

}
