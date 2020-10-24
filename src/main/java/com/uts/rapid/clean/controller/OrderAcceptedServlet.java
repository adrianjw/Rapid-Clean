/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.Customer;
import com.uts.rapid.clean.model.Order;
import com.uts.rapid.clean.model.OrderAccepted;
import com.uts.rapid.clean.model.OrderCompleted;
import com.uts.rapid.clean.model.dao.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author trandamtrungthai
 */
public class OrderAcceptedServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderAcceptedServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderAcceptedServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        String customerId = customer.getId();
        
        OrderDAO orderDAO = (OrderDAO) session.getAttribute("orderDAO");
        
        OrderAccepted orderAccepted = null;
        Order order = null;
        OrderCompleted orderCompleted = null;
        
        ArrayList<String> orderIdList = orderDAO.getOrderList(customerId);
        
        //find orderid in orderAccepted
        String orderAcceptedId = ""; //this is the orderId to put in parameter to find order
        for (String orderId : orderIdList) {
            boolean checkOrderAcceptedExist = orderDAO.checkOrderAcceptedExist(orderId);
            if (checkOrderAcceptedExist == true) {
                orderAcceptedId = orderId;
                orderAccepted = orderDAO.findOrderAccepted(orderAcceptedId);
            } else {
                continue;
            }
        }
        
        //find orderid in orderCompleted
        String orderCompletedId = "";
        for (String orderId : orderIdList) {
            boolean checkOrderCompletedExist = orderDAO.checkOrderCompletedExist(orderId);
            if (checkOrderCompletedExist == true) {
                orderCompletedId = orderId;
//                orderCompleted = orderDAO.findOrderCompleted(orderCompletedId);
            } else {
                continue;
            }
        }
        
        try {
            orderCompleted = orderDAO.findOrderCompleted(orderCompletedId);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
                
        if (orderAccepted != null) {
            order = orderDAO.order(orderAcceptedId);
            session.setAttribute("orderAccepted", orderAccepted);
            session.setAttribute("orderCompleted", orderCompleted);
            session.setAttribute("order", order);
        } else if (orderCompleted != null) {
            session.setAttribute("orderAccepted", orderAccepted);
            session.setAttribute("orderCompleted", orderCompleted);
        } else {
            session.setAttribute("orderAccepted", orderAccepted);
            session.setAttribute("orderCompleted", orderCompleted);
            session.setAttribute("order", order);
        }
                        
        try {
            request.getRequestDispatcher("order-pay.jsp").include(request, response);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
            request.getRequestDispatcher("order-pay.jsp").include(request, response);
        } 
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
