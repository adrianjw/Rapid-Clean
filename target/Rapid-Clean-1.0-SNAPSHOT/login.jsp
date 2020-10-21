<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/user-access-mgmt.css" rel="stylesheet" type="text/css">
        <title>Login</title>
    </head>
    <body>
        <a href="index.jsp"><button class="back">←</button></a>
        <form action="LoginServlet" method="POST">
            <table>
                <tr>
                    <td>Email</td>
                </tr>
                <tr>
                    <td><input type="email" name="email" required></td>
                </tr>
                <tr>
                    <td>Password</td>
                </tr>
                <tr>
                    <td><input type="password" name="password" required></td>
                </tr>
                <tr>
                    <td class="error-message"><%=session.getAttribute("loginError")%></td>
                </tr>
            </table>
            <button class="regular" type="submit">Login</button>
        </form>
    </body>
</html>
