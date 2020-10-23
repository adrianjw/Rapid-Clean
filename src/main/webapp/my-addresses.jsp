<%@page import="java.util.List"%>
<%@page import="com.uts.rapid.clean.model.Address"%>
<%@page import="com.uts.rapid.clean.model.Customer"%>
<%@page import="com.uts.rapid.clean.model.dao.AddressDAO"%>
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
        <title>My Addresses</title>
    </head>
    <body>
        <%
            Customer customer = (Customer) session.getAttribute("customer");
            AddressDAO addressDAO = (AddressDAO) session.getAttribute("addressDAO");
            List<Address> addresses = addressDAO.findAddressByCustomerId(customer.getId());
        %>
        <div id="nav-placeholder"></div>
        <div class="main">
            <h2 class="action-result-message"><%=session.getAttribute("actionResult")%></h2>
            <h1>My Addresses</h1>
            <a href="create-address.jsp"><div class="add-address-button">Add address</div></a>
            <%for (Address address : addresses) {%>
                <div class="address-block">
                    <p><%=address.getStreetAddress()%><br><%=address.getSuburb()%> <%=address.getState()%> <%=address.getPostcode()%></p>
                    <a href="edit-address.jsp"><button>Edit</button></a>
                    <a href="DeleteAddressServlet?addressId=<%=address.getId()%>"><button>Remove</button></a>
                </div>
            <%}%>
        </div>
        <%
            session.setAttribute("streetAddressError", "");
            session.setAttribute("suburbError", "");
            session.setAttribute("postcodeError", "");
            session.setAttribute("addressExistError", "");
            session.setAttribute("actionResult", "");
        %>
    </body>
</html>
