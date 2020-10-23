<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/address-mgmt.css" rel="stylesheet" type="text/css">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
          $(function(){
          $("#nav-placeholder").load("navigationbar.jsp");
          });
        </script>
        <title>Add Address</title>
    </head>
    <body>
        <div id="nav-placeholder"></div>
        <div class="parent">
            <div class="child">
                <h2>Add a new address</h2>
                <form action="CreateAddressServlet" method="POST">
                    <table>
                        <tr>
                            <td colspan="3">Street Address</td>
                        </tr>
                        <tr>
                            <td colspan="3"><input class="long" type="text" name="streetAddress" maxlength="200" required></td>
                        </tr>
                        <tr>
                            <td class="error-message"><%=session.getAttribute("streetAddressError")%></td>
                        </tr>
                        <tr>
                            <td>Suburb</td>
                            <td>State</td>
                            <td>Postcode</td>
                        </tr>
                        <tr>
                            <td><input class="short" type="text" name="suburb" maxlength="50" required></td>
                            <td>
                                <select name="state" required>
                                    <option value="">Select</option>
                                    <option value="ACT">ACT</option>
                                    <option value="NSW">NSW</option>
                                    <option value="NT">NT</option>
                                    <option value="QLD">QLD</option>
                                    <option value="SA">SA</option>
                                    <option value="TAS">TAS</option>
                                    <option value="VIC">VIC</option>
                                    <option value="WA">WA</option>
                                </select>
                            </td>
                            <td><input class="short" type="text" name="postcode" maxlength="4" required></td>
                        </tr>
                        <tr>
                            <td class="error-message"><%=session.getAttribute("suburbError")%></td>
                            <td></td>
                            <td class="error-message"><%=session.getAttribute("postcodeError")%></td>
                        </tr>
                        <tr>
                            <td class="error-message" colspan="3"><%=session.getAttribute("addressExistError")%></td>
                        </tr>
                    </table>
                    <button class="regular" type="submit">Add address</button>
                    <a href="my-addresses.jsp"><button class="regular" type="button">Cancel</button></a>
                </form>
            </div>
        </div>
    </body>
</html>
