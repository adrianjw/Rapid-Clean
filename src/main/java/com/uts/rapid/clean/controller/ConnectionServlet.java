package com.uts.rapid.clean.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mongodb.client.MongoDatabase;
import com.uts.rapid.clean.model.dao.*;

public class ConnectionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {      
        MongoDatabase database = new MongoDB().getDatabase();
        HttpSession session = request.getSession();
        
        session.setAttribute("firstNameError", "");
        session.setAttribute("lastNameError", "");
        session.setAttribute("emailError", "");
        session.setAttribute("passwordError", "");
        session.setAttribute("confirmPasswordError", "");
        session.setAttribute("phoneNumberError", "");
        session.setAttribute("bankBsbNumberError", "");
        session.setAttribute("bankAccountNumberError", "");
        session.setAttribute("bankAccountHolderNameError", "");
        session.setAttribute("loginError", "");
        
        session.setAttribute("customerDAO", new CustomerDAO(database));
        session.setAttribute("customerDAO", new CleanerDAO(database));
        session.setAttribute("customerDAO", new AddressDAO(database));
        session.setAttribute("customerDAO", new OrderDAO(database));
        session.setAttribute("customerDAO", new RatingDAO(database));
        session.setAttribute("customerDAO", new AcceptServiceDAO(database));
    }
}
