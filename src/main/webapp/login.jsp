<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/useraccessmgmt.css" rel="stylesheet" type="text/css">
        <title>Login</title>
    </head>
    <%
        String emailErr = request.getParameter("emailErr");
        String passwordErr = request.getParameter("passErr");
        String emptyErr = request.getParameter("empty");
    %>
    <body>
        <form action="LoginServlet" method="POST">
            <table>
                <tr>
                    <td>Email</td>
                </tr>
                <tr>
                    <td>
                        <input type="email" class="form-control" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" id="inputEmail1"name="email"required>
                    </td>
                </tr>
                <tr>
                    <td>Password</td>
                </tr>
                <tr>
                    <td><input type="password" class="form-control" placeholder="<%=(passwordErr != null ? passwordErr : "Enter password")%>" id="inputPassword1" name="password"required></td>
                </tr>
                <tr>
                    <td class="errorMessage"><%=session.getAttribute("loginError")%></td>
                </tr>
            </table>
            <a href="myaccount.jsp"><button class="button" type="submit"> Login </button></a>
            <a href="index.jsp"><button class="button" type="button"> Go Back </button></a>
        </form>
    </body>
</html>
