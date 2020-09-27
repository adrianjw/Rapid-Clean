package com.uts.rapid.clean.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.uts.rapid.clean.model.dao.CustomerDAO;
import com.uts.rapid.clean.model.dao.CleanerDAO;

public class CleanerSignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        CustomerDAO customerDAO = new CustomerDAO();
        CleanerDAO cleanerDAO = new CleanerDAO();
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String phoneNumber = request.getParameter("phoneNumber");
        String bankBsbNumber = request.getParameter("bankBsbNumber");
        String bankAccountNumber = request.getParameter("bankAccountNumber");
        String bankAccountHolderName = request.getParameter("bankAccountHolderName");
        
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
        
        if (validator.validatePassword(password))
            validationTestPassed++;
        else
            session.setAttribute("passwordError", "Invalid password");
        
        if (password.equals(confirmPassword))
            validationTestPassed++;
        else
            session.setAttribute("confirmPasswordError", "Passwords do not match");
        
        if (validator.validatePhoneNumber(phoneNumber))
            validationTestPassed++;
        else
            session.setAttribute("phoneNumberError", "Invalid phone number");
        
        if (validator.validateBankNumber(bankBsbNumber))
            validationTestPassed++;
        else
            session.setAttribute("bankBsbNumberError", "Invalid BSB number");
        
        if (validator.validateBankNumber(bankAccountNumber))
            validationTestPassed++;
        else
            session.setAttribute("bankAccountNumberError", "Invalid account number");
        
        if (validator.validateBankName(bankAccountHolderName))
            validationTestPassed++;
        else
            session.setAttribute("bankAccountHolderNameError", "Invalid account holder name");
        
        if (validationTestPassed == 9) {
            if (!customerDAO.hasCustomer(email) && !cleanerDAO.hasCleaner(email)) {
                cleanerDAO.createCleaner(firstName, lastName, email, password, phoneNumber,
                        Integer.parseInt(bankBsbNumber), Integer.parseInt(bankAccountNumber),
                        bankAccountHolderName);
                session.setAttribute("cleaner", cleanerDAO.findCleaner(email, password));
                request.getRequestDispatcher("/CleanerOrderServlet").include(request, response);
            }
            else {
                session.setAttribute("emailError", "Email address already in use");
                request.getRequestDispatcher("cleanersignup.jsp").include(request, response);
            }
        }
        else {
            request.getRequestDispatcher("cleanersignup.jsp").include(request, response);
        }
    }
}
