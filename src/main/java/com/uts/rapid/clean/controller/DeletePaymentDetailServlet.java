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
public class DeletePaymentDetailServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String paymentId = request.getParameter("paymentDetailId");
        String customerId = request.getParameter("customerId");
        PaymentDetailsDAO manager = (PaymentDetailsDAO) session.getAttribute("paymentDetailsDAO");
        
        // Delete payment base on paymentId
       manager.deletePaymentDetail(paymentId);

       // Redirect user to the same page
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
