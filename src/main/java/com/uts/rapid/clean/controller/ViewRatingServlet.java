package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.Rating;
import com.uts.rapid.clean.model.dao.RatingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ViewRatingServlet", urlPatterns = {"/ViewRatingServlet"})
public class ViewRatingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get current session, ratingDAO
        HttpSession session = request.getSession();
        //RatingDAO ratingDAO = (RatingDAO) session.getAttribute("ratingDAO");
        RatingDAO ratingDAO = new RatingDAO();
        
        // Stores all ratings in arraylist and displays
        try {
        ArrayList<Rating> allRatings = ratingDAO.viewAllRatings();
        System.out.println(allRatings.size());
        session.setAttribute("listRatings", allRatings);
        } catch (NullPointerException e) { 
            System.out.println("Missing Resources!");
        } catch (Exception e) {
            ArrayList<Rating> allRatings = ratingDAO.viewAllRatings();
            System.out.println(allRatings.size());
            System.out.println("Cannot view Ratings");
        }
        
        // Redirects to All Ratings and forward req,res resources
        RequestDispatcher dispatcher = request.getRequestDispatcher("ratings.jsp");
        dispatcher.forward(request, response);
    }
    
    // In the case that GET is triggered, do POST
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
