<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.uts.rapid.clean.controller.Validator"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/useraccessmgmt.css" rel="stylesheet" type="text/css">
        <title>Sign Up</title>
    </head>
    <body>
        <div>
            <a href="index.jsp"><button class="back-button">←</button></a>
            <h1> Sign Up As </h1>
        </div>
        <div>
            <a href="customer-signup.jsp"><button class="customer-button"> Customer </button></a>
            <a href="cleaner-signup.jsp"><button class="cleaner-button"> Cleaner </button></a>
        </div>
        <%
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
        %>
    </body>
</html>
