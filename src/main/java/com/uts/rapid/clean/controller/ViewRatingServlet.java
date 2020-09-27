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
import org.bson.types.ObjectId;

@WebServlet(name = "ViewRatingServlet", urlPatterns = {"/ViewRatingServlet"})
public class ViewRatingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get current session, ratingDAO
        HttpSession session = request.getSession();
        RatingDAO ratingDAO = new RatingDAO();
        // Cleaner cleaner = (Cleaner) session.getAttribute("cleaner");  
        
        // Stores all ratings in arraylist and displays
        ArrayList<Rating> listRatings = ratingDAO.viewAllRatings();
        System.out.println(listRatings.size());
        session.setAttribute("listRatings", listRatings);

        System.out.println("\n\nTotal Entries: "+listRatings.size()+"\n\n");
        
        // Redirects to All Ratings and forward req,res resources
        request.getRequestDispatcher("ratings.jsp").include(request, response);
    }

}
