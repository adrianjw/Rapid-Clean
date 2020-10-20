package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.Rating;
import com.uts.rapid.clean.model.dao.RatingDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewRatingServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get current session, ratingDAO
        HttpSession session = request.getSession();
        RatingDAO ratingDAO = (RatingDAO) session.getAttribute("ratingDAO");
        
        // Stores all ratings in arraylist and displays
        ArrayList<Rating> listRatings = ratingDAO.viewAllRatings();
        System.out.println(listRatings.size());
        session.setAttribute("listRatings", listRatings);

        System.out.println("\n\nTotal Entries: "+listRatings.size()+"\n\n");
        
        // Redirects to All Ratings and forward req,res resources
        request.getRequestDispatcher("my-ratings.jsp").forward(request, response);
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
