package com.uts.rapid.clean.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.uts.rapid.clean.model.dao.*;

public class ConnectionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {      
        MongoDB mongoDB = new MongoDB();
        MongoClient mongoClient = mongoDB.getMongoClient();
        MongoDatabase database = mongoDB.getDatabase();
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
        
        session.setAttribute("mongoClient", mongoClient);
        session.setAttribute("customerDAO", new CustomerDAO(database));
        session.setAttribute("cleanerDAO", new CleanerDAO(database));
        session.setAttribute("addressDAO", new AddressDAO(database));
        session.setAttribute("orderDAO", new OrderDAO(database));
        session.setAttribute("ratingDAO", new RatingDAO(database));
        session.setAttribute("acceptServiceDAO", new AcceptServiceDAO(database));
    }
}
