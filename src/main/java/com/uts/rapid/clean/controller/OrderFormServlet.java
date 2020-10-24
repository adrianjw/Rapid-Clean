package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.Customer;
import com.uts.rapid.clean.model.dao.AddressDAO;
import com.uts.rapid.clean.model.dao.OrderDAO;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderFormServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String orderCategory = request.getParameter("orderCategory");
        String orderCategoryDesc = request.getParameter("orderCategoryDesc");
        double hourlyRate = Double.parseDouble(request.getParameter("hourlyRate"));
        String residentialType = request.getParameter("residentialType");
        
        String streetAddress = request.getParameter("streetAddress");
        String suburb = request.getParameter("suburb");
        String state = request.getParameter("state");
        String postcode = request.getParameter("postcode");
        
        OrderDAO orderDAO = (OrderDAO) session.getAttribute("orderDAO");
        AddressDAO addressDAO = (AddressDAO) session.getAttribute("addressDAO");
        
        Customer customer = (Customer) session.getAttribute("customer");
              
        Date dateTime = new Date();
        
        String customerId = customer.getId();
        
        
        addressDAO.createAddress(customerId, streetAddress, suburb, state, Integer.parseInt(postcode));
        
        String addressId = orderDAO.findAddress(customerId);
        
        orderDAO.addOrder(customerId, addressId, residentialType, hourlyRate, orderCategory, orderCategoryDesc, dateTime);
        
        request.getRequestDispatcher("orderload.jsp").forward(request, response);
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
