package com.uts.rapid.clean.controller;

import com.mongodb.client.MongoClient;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        MongoClient mongoClient = (MongoClient) session.getAttribute("mongoClient");
        mongoClient.close();
        session.invalidate();
        request.getRequestDispatcher("index.jsp").include(request, response);
    }
}