
package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.Cleaner;
import com.uts.rapid.clean.model.Customer;
import com.uts.rapid.clean.model.Ticket;
import com.uts.rapid.clean.model.dao.TicketDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TicketCreateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        TicketDAO ticketDAO = (TicketDAO) session.getAttribute("ticketDAO");
        Customer customer = (Customer) session.getAttribute("customer");
        Cleaner cleaner = (Cleaner) session.getAttribute("cleaner");
        
        if (customer != null) {
            String id = request.getParameter("ticketId");
            String customerId = customer.getId();
            String priority = "";
            String status = "Unresolved";
            String subject = request.getParameter("subject");
            String department = request.getParameter("department");
            String comment = request.getParameter("comment");
            Date date = new Date();

            Ticket newTicket = new Ticket(id, customerId, priority, status, subject, department, comment, date);
            ticketDAO.createTicket(newTicket);
            
            // Re-directs to Contact Us page
            request.getRequestDispatcher("contact-us.jsp").forward(request, response);
            
        } else if (cleaner != null) {
            String id = request.getParameter("cleaner-ticketId");
            String cleanerId = cleaner.getId();
            String priority = "";
            String status = "Unresolved";
            String subject = request.getParameter("cleaner-subject");
            String department = request.getParameter("cleaner-department");
            String comment = request.getParameter("cleaner-comment");
            Date date = new Date();

            Ticket newTicket = new Ticket(id, cleanerId, priority, status, subject, department, comment, date);
            ticketDAO.createTicket(newTicket);
            
            // Re-directs to Support page
            request.getRequestDispatcher("cleaner-home.jsp").forward(request, response);
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
