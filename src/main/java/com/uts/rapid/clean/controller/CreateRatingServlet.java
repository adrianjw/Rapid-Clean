
package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.*;
import com.uts.rapid.clean.model.dao.RatingDAO;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.bson.types.ObjectId;

public class CreateRatingServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get current session, customer, paid order and ratingDAO
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        RatingDAO ratingDAO = (RatingDAO) session.getAttribute("ratingDAO");
        
        // Gets all details/parameters/input
        String id = new ObjectId().toHexString(); // Randomised new ID
        
        String customerId = customer.getId(); // Pre-existing
        // String customerId = new ObjectId().toHexString();
        
        String orderCompleteId = request.getParameter("orderCompletedId"); // Pre-existing
        
        String rating = request.getParameter("rating"); // Form
        String comment = request.getParameter("comment"); // Form
        Date date = new Date(); // Current time
        
        // Create Rating object to be converted and added to the database
        Rating rate = new Rating(id, customerId, orderCompleteId, Integer.parseInt(rating), comment, date);
        ratingDAO.createRating(rate);
        
        // Re-directs to Home
        request.getRequestDispatcher("home.jsp").forward(request, response);
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
