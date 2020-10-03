package com.uts.rapid.clean.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.uts.rapid.clean.model.dao.*;

public class ConnectionServlet extends HttpServlet {
    
    private MongoClient mongoClient;
    private MongoDatabase database;
    private CustomerDAO customerDAO;
    private CleanerDAO cleanerDAO;
    private AddressDAO addressDAO;
    private OrderDAO orderDAO;
    private RatingDAO ratingDAO;
    private AcceptServiceDAO acceptServiceDAO;
    
    @Override
    public void init() {
        MongoDB mongoDB = new MongoDB();
        mongoClient = mongoDB.getMongoClient();
        database = mongoDB.getDatabase();
        customerDAO = new CustomerDAO(database);
//        cleanerDAO = new CleanerDAO(database);
        addressDAO = new AddressDAO(database);
        orderDAO = new OrderDAO(database);
        ratingDAO = new RatingDAO(database);
        acceptServiceDAO = new AcceptServiceDAO(database);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {      
        HttpSession session = request.getSession();
        
        session.setAttribute("mongoClient", mongoClient);
        session.setAttribute("customerDAO", customerDAO);
//        session.setAttribute("cleanerDAO", cleanerDAO);
        session.setAttribute("addressDAO", addressDAO);
        session.setAttribute("orderDAO", orderDAO);
        session.setAttribute("ratingDAO", ratingDAO);
        session.setAttribute("acceptServiceDAO", acceptServiceDAO);
        
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
    }
    
    @Override
    public void destroy() {
        mongoClient.close();
    }
}
