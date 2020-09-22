<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/useraccessmgmt.css" rel="stylesheet" type="text/css">
        <title>Customer Sign Up</title>
    </head>
    <body>
        <form action="CustomerSignUpServlet" method="POST">
            <table>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstName" required></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName" required></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="email" name="email" required></td>
                </tr>
                <tr>
                    <td>Phone Number</td>
                    <td><input type="text" name="phone" required></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" required></td>
                </tr>
                <tr>
                    <td>Confirm Password</td>
                    <td><input type="password" name="confirmPassword" required></td>
                </tr>
            </table>
            <button class="button" type="submit"> Create Account </button>
            <a href="signup.jsp"><button class="button"> Go Back </button></a>
        </form>
    </body>
</html>
