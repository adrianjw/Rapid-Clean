package com.uts.rapid.clean.controller;

import com.uts.rapid.clean.model.*;
import com.uts.rapid.clean.model.dao.AcceptServiceDAO;
import java.io.IOException;
import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CleanerOrderCompletedServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cleanerId = request.getParameter("cleanerId");
        String orderId = request.getParameter("orderId");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        AcceptServiceDAO orderManager = new AcceptServiceDAO();

        // Format the String Time to Date Time format
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        try {
            Order orderedCompleted = orderManager.order(orderId);
            Cleaner cleaner = orderManager.findCleaner(cleanerId);
            Date startTimeFormatted = format.parse(startTime);
            Date endTimeFormatted = format.parse(endTime);
            long difference = endTimeFormatted.getTime() - startTimeFormatted.getTime();
            double workedHours = (orderedCompleted.getHourlyRate() / 60) * ((difference / (1000 * 60))% 24);
            
            
            // When inserted to MongoDB, date will be recorded as the starting value of the Date datatype in MongoDB
            // Only the time part is used in the date attribute, so the value of date don't matter.
            orderManager.insertCompletedOrder(orderId, startTimeFormatted, endTimeFormatted, workedHours, cleanerId);
            OrderCompleted orderCompleted = orderManager.findOrderCompleted(orderId);
            
            
            session.setAttribute("orderCompleted", orderCompleted);
            session.setAttribute("cleaner", cleaner);
            request.getRequestDispatcher("cleanerordercompleted.jsp").include(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CleanerOrderCompletedServlet.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        // Insert the order_id, startTime, endTime, workdedHours and cleaner_id
    }
}
