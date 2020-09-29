/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.*;
import com.uts.rapid.clean.model.Rating;
import com.uts.rapid.clean.model.dao.CleanerDAO;
import com.uts.rapid.clean.model.dao.CustomerDAO;
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

@WebServlet(name = "DeleteCustomerServlet", urlPatterns = {"/DeleteCustomerServlet"})

public class DeleteAccountServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            CustomerDAO customerDAO = new CustomerDAO();
            CleanerDAO cleanerDAO = new CleanerDAO();
            // Gets user id
            String id = request.getParameter("id");

            // Deletes the user
            customerDAO.deleteCustomer(id);
            cleanerDAO.deleteCleaner(id);
            
            // Redirects to index
            request.getRequestDispatcher("index.jsp").include(request, response);
        
        } catch (NullPointerException e) { 
            System.out.println("Missing Resources!");
        } catch (Exception e) {
            System.out.println("Account cannot be deleted!");
        }
    }
}
