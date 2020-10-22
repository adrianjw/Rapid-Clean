
package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.Ticket;
import com.uts.rapid.clean.model.dao.TicketDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TicketViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        TicketDAO ticketDAO = (TicketDAO) session.getAttribute("ticketDAO");
        
        String ticketId = (String) request.getParameter("ticketId");
        Ticket ticket = ticketDAO.findTicket(ticketId);
        
        session.setAttribute("ticket", ticket);
        
        // Re-directs to Home
        request.getRequestDispatcher("ticket-view.jsp").forward(request, response);
    }

}
