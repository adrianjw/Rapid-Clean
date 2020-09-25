/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.*;
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

@WebServlet(name = "DeleteRatingServlet", urlPatterns = {"/DeleteRatingServlet"})
public class DeleteRatingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
        // Get current session and ratingDAO
        HttpSession session = request.getSession();
        RatingDAO ratingDAO = (RatingDAO) session.getAttribute("ratingDAO");
        
        // Gets Rating id
        String id = request.getParameter("id");

        // Deletes the rating
        ratingDAO.deletRating(id);
        
        } catch (NullPointerException e) { 
            System.out.println("Missing Resources!");
        } catch (Exception e) {
            System.out.println("Rating cannot be deleted!");
        }
        // Redirects to ratings list
        response.sendRedirect("orderhistory.jsp");
    }
    
    // In the case that POST is triggered, do GET
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}