package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.Order;
import com.uts.rapid.clean.model.dao.AcceptServiceDAO;
import com.uts.rapid.clean.model.dao.AddressDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CleanerOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cleanerId = request.getParameter("cleanerId");
        AcceptServiceDAO manager = new AcceptServiceDAO();
        ArrayList <Order> orderD = null;
        
        orderD = manager.orderList();
        if (orderD != null) {
            session.setAttribute("orderD", orderD);
            request.getRequestDispatcher("cleanerhome.jsp").include(request, response);
        } else {
            session.setAttribute("orderErr", "There are no orders available around your area");
            request.getRequestDispatcher("cleanerhome.jsp").include(request, response);
        }
        }
        
    }
