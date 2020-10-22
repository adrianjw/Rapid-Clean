/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.dao.PaymentDetailsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author David Guntoro
 */
public class CreatePaymentDetailServlet extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String customerId = request.getParameter("customerId");
        PaymentDetailsDAO manager = (PaymentDetailsDAO) session.getAttribute("paymentDetailsDAO");
        
        String cardNumber = request.getParameter("cardNumber");
        String cvcs = request.getParameter("cvc");
        int cvc = 121;
        String expirtyDate = request.getParameter("expiryDate");
        String cardholderName = request.getParameter("cardholderName");
        String customer_id = request.getParameter("customer_id");
        
        manager.createPaymentDetail(customer_id, cardNumber, expirtyDate, cvc, cardholderName);
        request.getRequestDispatcher("/PaymentDetailServlet?customerId=" + customerId).forward(request, response);
        
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
