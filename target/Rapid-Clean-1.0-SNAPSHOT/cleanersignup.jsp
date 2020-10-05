<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/useraccessmgmt.css" rel="stylesheet" type="text/css">
        <title>Cleaner Sign Up</title>
    </head>
    <body>
        <a href="signup.jsp"><button class="back-button">←</button></a>
        <form action="CleanerSignUpServlet" method="GET">
            <table>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstName" maxlength="50" required></td>
                    <td class="errorMessage"><%=session.getAttribute("firstNameError")%></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName" maxlength="50" required></td>
                    <td class="errorMessage"><%=session.getAttribute("lastNameError")%></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="email" name="email" maxlength="100" required></td>
                    <td class="errorMessage"><%=session.getAttribute("emailError")%></td>
                </tr>
                <tr>
                    <td>Phone Number</td>
                    <td><input type="text" name="phoneNumber" minlength="10" maxlength="10" required></td>
                    <td class="errorMessage"><%=session.getAttribute("phoneNumberError")%></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" minlength="8" maxlength="50" required></td>
                    <td class="errorMessage"><%=session.getAttribute("passwordError")%></td>
                </tr>
                <tr>
                    <td>Confirm Password</td>
                    <td><input type="password" name="confirmPassword" minlength="8" maxlength="50" required></td>
                    <td class="errorMessage"><%=session.getAttribute("confirmPasswordError")%></td>
                </tr>
                <tr>
                    <td>BSB Number</td>
                    <td><input type="text" name="bankBsbNumber" minlength="6" maxlength="6" required></td>
                    <td class="errorMessage"><%=session.getAttribute("bankBsbNumberError")%></td>
                </tr>
                <tr>
                    <td>Account Number</td>
                    <td><input type="text" name="bankAccountNumber" minlength="6" maxlength="6" required></td>
                    <td class="errorMessage"><%=session.getAttribute("bankAccountNumberError")%></td>
                </tr>
                <tr>
                    <td>Account Holder Name</td>
                    <td><input type="text" name="bankAccountHolderName" maxlength="100" required></td>
                    <td class="errorMessage"><%=session.getAttribute("bankAccountHolderNameError")%></td>
                </tr>
            </table>
            <button class="regular-button" type="submit"> Create Account </button>
        </form>
    </body>
</html>
