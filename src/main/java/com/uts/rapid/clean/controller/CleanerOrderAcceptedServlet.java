package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.*;
import com.uts.rapid.clean.model.dao.AcceptServiceDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CleanerOrderAcceptedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        AcceptServiceDAO acceptServiceDAO = (AcceptServiceDAO) session.getAttribute("acceptServiceDAO");
        String orderId = request.getParameter("orderId");
        String customerId = request.getParameter("customerId");
        String cleanerId = request.getParameter("cleanerId");

        Order orderAccepted = acceptServiceDAO.order(orderId);
        Customer customer = acceptServiceDAO.findCustomer(customerId);
        Address address = acceptServiceDAO.address(orderAccepted.getAddress_id());

        // Insert the order to AcceptOrder Database to avoid being displayed for other cleaners
        acceptServiceDAO.insertAcceptOrder(orderId, cleanerId);

        session.setAttribute("orderAccepted", orderAccepted);
        session.setAttribute("customer", customer);
        session.setAttribute("address", address);
        request.getRequestDispatcher("cleanerorderaccepted.jsp").include(request, response);
    }
}
