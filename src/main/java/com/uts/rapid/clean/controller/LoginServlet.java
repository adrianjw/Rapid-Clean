package com.uts.rapid.clean.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.uts.rapid.clean.model.dao.CustomerDAO;
import com.uts.rapid.clean.model.dao.CleanerDAO;
import com.uts.rapid.clean.model.dao.StaffDAO;
import com.uts.rapid.clean.model.Customer;
import com.uts.rapid.clean.model.Cleaner;
import com.uts.rapid.clean.model.Staff;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        CustomerDAO customerDAO = (CustomerDAO) session.getAttribute("customerDAO");
        CleanerDAO cleanerDAO = (CleanerDAO) session.getAttribute("cleanerDAO");
        StaffDAO staffDAO = (StaffDAO) session.getAttribute("staffDAO");
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        Validator validator = new Validator();
        validator.clear(session);
        
        if (validator.validateEmail(email) && validator.validatePassword(password)) {
            Customer customer = customerDAO.findCustomer(email, password);
            Cleaner cleaner = cleanerDAO.findCleaner(email, password);
            Staff staff = staffDAO.findStaff(email, password);
            if (customer != null) {
                session.setAttribute("customer", customer);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
            else if (cleaner != null) {
                session.setAttribute("cleanerId", cleaner.getId());
                request.getRequestDispatcher("/CleanerOrderServlet").forward(request, response);
            }
            else if (staff != null) {
                session.setAttribute("staff", staff);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
            else {
                session.setAttribute("loginError", "Invalid username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
        else {
            session.setAttribute("loginError", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
