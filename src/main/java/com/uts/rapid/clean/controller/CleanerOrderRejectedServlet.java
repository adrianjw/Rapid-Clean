package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.*;
import com.uts.rapid.clean.model.dao.AcceptServiceDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CleanerOrderRejectedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        AcceptServiceDAO acceptServiceDAO = (AcceptServiceDAO) session.getAttribute("acceptServiceDAO");
        String orderId = request.getParameter("orderId");
        String cleanerId = request.getParameter("cleanerId");


        // Insert the order to OrderRejected Database to avoid being displayed for the particular cleaner after rejected
        acceptServiceDAO.insertRejectOrder(orderId, cleanerId);

        request.getRequestDispatcher("/CleanerOrderServlet?cleanerId=" + cleanerId).forward(request, response);
    }
}
