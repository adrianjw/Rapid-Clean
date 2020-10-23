<%@page import="com.uts.rapid.clean.model.Address"%>
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
        <title>Edit Address</title>
    </head>
    <body>
        <%Address address = (Address) session.getAttribute("address");%>
        <%String state = address.getState();%>
        <div id="nav-placeholder"></div>
        <div class="parent">
            <div class="child">
                <h2>Update your address</h2>
                <form action="UpdateAddressServlet?addressId=<%=address.getId()%>" method="POST">
                    <table>
                        <tr>
                            <td colspan="3">Street Address</td>
                        </tr>
                        <tr>
                            <td colspan="3"><input class="long" type="text" name="streetAddress" maxlength="200" value="<%=address.getStreetAddress()%>" required></td>
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
                            <td><input class="short" type="text" name="suburb" maxlength="50" value="<%=address.getSuburb()%>" required></td>
                            <td>
                                <select name="state" required>
                                    <option value="<%=state%>"><%=state%></option>
                                    <%if (!state.equals("ACT")) {%> <option value="ACT">ACT</option> <%}%>
                                    <%if (!state.equals("NSW")) {%> <option value="NSW">NSW</option> <%}%>
                                    <%if (!state.equals("NT")) {%> <option value="NT">NT</option> <%}%>
                                    <%if (!state.equals("QLD")) {%> <option value="QLD">QLD</option> <%}%>
                                    <%if (!state.equals("SA")) {%> <option value="SA">SA</option> <%}%>
                                    <%if (!state.equals("TAS")) {%> <option value="TAS">TAS</option> <%}%>
                                    <%if (!state.equals("VIC")) {%> <option value="VIC">VIC</option> <%}%>
                                    <%if (!state.equals("WA")) {%> <option value="WA">WA</option> <%}%>
                                </select>
                            </td>
                            <td><input class="short" type="text" name="postcode" maxlength="4" value="<%=address.getPostcode()%>" required></td>
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
                    <button class="regular" type="submit">Save changes</button>
                    <a href="my-addresses.jsp"><button class="regular" type="button">Cancel</button></a>
                </form>
            </div>
        </div>
    </body>
</html>
