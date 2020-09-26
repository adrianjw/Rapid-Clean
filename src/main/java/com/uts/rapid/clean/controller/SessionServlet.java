package com.uts.rapid.clean.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("firstNameError", "");
        session.setAttribute("lastNameError", "");
        session.setAttribute("emailError", "");
        session.setAttribute("passwordError", "");
        session.setAttribute("confirmPasswordError", "");
        session.setAttribute("phoneNumberError", "");
        session.setAttribute("bankBsbNumberError", "");
        session.setAttribute("bankAccountNumberError", "");
        session.setAttribute("bankAccountHolderNameError", "");
        session.setAttribute("loginError", "");
    }
}
