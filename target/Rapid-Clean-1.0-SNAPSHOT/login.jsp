<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/useraccessmgmt.css" rel="stylesheet" type="text/css">
        <title>Login</title>
    </head>
    <body>
        <form action="LoginServlet" method="GET">
            <table>
                <tr>
                    <td>Email</td>
                </tr>
                <tr>
                    <td><input type="email" name="email"></td>
                </tr>
                <tr>
                    <td>Password</td>
                </tr>
                <tr>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td class="errorMessage"><%=session.getAttribute("loginError")%></td>
                </tr>
            </table>
            <button class="button" type="submit"> Login </button>
            <a href="home.jsp"><button class="button" type="button"> Go Back </button></a>
        </form>
    </body>
</html>
