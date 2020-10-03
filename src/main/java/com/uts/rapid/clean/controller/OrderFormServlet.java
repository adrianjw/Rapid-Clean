package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.Customer;
import com.uts.rapid.clean.model.Order;
import com.uts.rapid.clean.model.dao.AddressDAO;
import com.uts.rapid.clean.model.dao.MongoDB;
import com.uts.rapid.clean.model.dao.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.bson.Document;

public class OrderFormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
        
        Customer customer = (Customer) session.getAttribute("customer");
              
        Date dateTime = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss z");
        
        String customerId = customer.getId();
        OrderDAO orderDAO = (OrderDAO) session.getAttribute("orderDAO");
        
        orderDAO.insertAddress(customerId, streetAddress, suburb, state, Integer.parseInt(postcode));
//        String dateTime = formatter.format(date);
//        Date newDateTime = formatter.parse(dateTime);
        
                
        
        String addressId = orderDAO.findAddress(customerId);        
        
        orderDAO.addOrder(customerId, addressId, residentialType, hourlyRate, orderCategory, orderCategoryDesc, dateTime);
        
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
