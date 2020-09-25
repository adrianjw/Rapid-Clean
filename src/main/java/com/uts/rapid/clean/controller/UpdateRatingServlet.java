/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.Rating;
import com.uts.rapid.clean.model.dao.RatingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sandy
 */
@WebServlet(name = "UpdateRatingServlet", urlPatterns = {"/UpdateRatingServlet"})
public class UpdateRatingServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Gets current session and DAO
        HttpSession session = request.getSession();
        RatingDAO ratingDAO = (RatingDAO) session.getAttribute("ratingDAO");
        
        // Gets all details/parameters/input from the form
        String id = request.getParameter("id");
        String customerId = request.getParameter("customerId");
        String orderHistoryId = request.getParameter("orderHistoryId");
        int rating = Integer.parseInt(request.getParameter("rating"));
        String comment = request.getParameter("comment");
        Date date = new Date(); // Update with last modified
        
        // Update rating by creating a Rating object with those details
        try {
            Rating rate = new Rating(id, customerId, orderHistoryId, rating, comment, date);
            ratingDAO.updateRating(rate);
            
        } catch (NullPointerException e) { 
            System.out.println("Missing Resources!");
        } catch (Exception e) {
            System.out.println("Cannot update Rating!");
        }
        
        // Redirects to order history, forward req/res resources
        RequestDispatcher dispatcher = request.getRequestDispatcher("orderhistory.jsp");
        dispatcher.forward(request, response);
    }
    
    // In the case that POST is triggered, do GET
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


}
