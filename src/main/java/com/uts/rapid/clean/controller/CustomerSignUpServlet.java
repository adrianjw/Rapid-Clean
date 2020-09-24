package com.uts.rapid.clean.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.uts.rapid.clean.model.Customer;
import com.uts.rapid.clean.model.dao.CustomerDAO;

public class CustomerSignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        CustomerDAO customerDAO = new CustomerDAO();
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String phoneNumber = request.getParameter("phoneNumber");
        
        Validator validator = new Validator();
        validator.clear(session);
        int validationTestPassed = 0;
        
        if (validator.validateName(firstName))
            validationTestPassed++;
        else
            session.setAttribute("firstNameError", "Invalid name");
        
        if (validator.validateName(lastName))
            validationTestPassed++;
        else
            session.setAttribute("lastNameError", "Invalid name");
        
        if (validator.validateEmail(email))
            validationTestPassed++;
        else
            session.setAttribute("emailError", "Invalid email address");
        
        if (validator.validatePassword(password) && password.equals(confirmPassword))
            validationTestPassed++;
        else
            session.setAttribute("passwordError", "Passwords do not match");
        
        if (validator.validatePhoneNumber(phoneNumber))
            validationTestPassed++;
        else
            session.setAttribute("phoneNumberError", "Invalid phone number");
        
        if (validationTestPassed == 5) {
            customerDAO.createCustomer(firstName, lastName, email, password, phoneNumber);
            request.getRequestDispatcher("home.jsp").include(request, response);
        }
        else {
            request.getRequestDispatcher("customersignup.jsp").include(request, response);
        }
    }
}
