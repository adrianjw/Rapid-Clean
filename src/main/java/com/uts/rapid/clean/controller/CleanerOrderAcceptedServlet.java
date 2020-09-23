package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.dao.AcceptServiceDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CleanerOrderAcceptedServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
         AcceptServiceDAO orderManager = new AcceptServiceDAO();
         String orderId = request.getParameter("orderId");
         String customerId = request.getParameter("customerId");
    }
}
