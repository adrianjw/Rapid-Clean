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
        String invalidCardNumber = null;
        
        String cardNumber = request.getParameter("cardNumber");
        cardNumber = cardNumber.replaceAll("\\s+","");
        // Validation purposes check if there is 16 digits
        int cardNumberLength = cardNumber.length();
        
        String cvcs = request.getParameter("cvc");
        int cvc = Integer.parseInt(cvcs);
        
        String expiryDate = request.getParameter("expiryDate");
        expiryDate = expiryDate.replaceAll("\\s+","");
        
        String cardholderName = request.getParameter("cardholderName");
        String customer_id = request.getParameter("customerId");
        
        // Checks if there is 16 digits
        if (cardNumberLength == 16)
        {
        manager.createPaymentDetail(customer_id, cardNumber, expiryDate, cvc, cardholderName);
        request.getRequestDispatcher("/PaymentDetailServlet?customerId=" + customerId).forward(request, response);
        }
        else
        {
            invalidCardNumber = "Invalid Card Number! Please try again.";
            session.setAttribute("invalidCardNumber", invalidCardNumber);
            request.getRequestDispatcher("my-payment-details-add.jsp").forward(request, response);
        }
        
        
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
