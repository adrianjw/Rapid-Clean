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
                    <td><input type="text" name="firstName" maxlength="50" required></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName" maxlength="50" required></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="email" name="email" maxlength="100" required></td>
                </tr>
                <tr>
                    <td>Phone Number</td>
                    <td><input type="text" name="phoneNumber" minlength="10" maxlength="10" required></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" minlength="8" maxlength="50" required></td>
                </tr>
                <tr>
                    <td>Confirm Password</td>
                    <td><input type="password" name="confirmPassword" minlength="8" maxlength="50" required></td>
                </tr>
            </table>
            <button class="button" type="submit"> Create Account </button>
            <a href="signup.jsp"><button class="button" type="button"> Go Back </button></a>
        </form>
    </body>
</html>
