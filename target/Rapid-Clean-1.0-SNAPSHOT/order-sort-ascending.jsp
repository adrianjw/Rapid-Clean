<%-- 
    Document   : order-sort-ascending
    Created on : 27/08/2020, 1:44:27 PM
    Author     : trandamtrungthai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.uts.rapid.clean.model.Order"%>
<%@page import="com.uts.rapid.clean.model.Customer"%>
<%@page import="com.uts.rapid.clean.model.dao.OrderDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/card.css">  
        <link rel="stylesheet" href="css/orderhistory.css">
        <title>Order History</title>       
        
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
            $(function(){
            $("#nav-placeholder").load("navigationbar.jsp");
             });
        </script>
    </head>
    <body>
        <div id="nav-placeholder"></div>
        <div class="container">
        <%
            Customer customer = (Customer) session.getAttribute("customer");
            String customerId = customer.getId();
            OrderDAO orderDAO = (OrderDAO) session.getAttribute("orderDAO");
            orderDAO.getOrderList(customerId);
            ArrayList<Order> orders = (ArrayList<Order>) session.getAttribute("orders");
            request.setAttribute("orders", orders);
        %>
            <h1>Your Order History</h1>
            
            <form>
                <input type="text" name="value">
                <button class="card-btn">Search</button>
            </form>
            
            <form method="get" action="OrderHistoryServlet">
                <button class="card-btn">Sort by Date Descending</button>
            </form>
            
            <% for (Order order : orders) {%>
                <form action="ReOrderServlet" method="post">
                <div class="card">
                   <div class="card-body">
                       <input type="hidden" name="orderCategory" value="<%=order.getOrderCategory()%>">
                       <input type="hidden" name="residentialType" value="<%=order.getResidentialType()%>">
                       <input type="hidden" name="hourlyRate" value="<%=order.getHourlyRate()%>">
                       <input type="hidden" name="orderCategoryDesc" value="<%=order.getOrderCategoryDesc()%>">
                       <input type="hidden" name="addressId" value="<%=order.getAddress_id()%>">
                       
                       <h4><%=order.getId()%></h4>
                       <h4><%=order.getDateTime()%></h4> 
                       <p class="card-text">Service: <%=order.getOrderCategory()%></p>
                       <p class="card-text">Residential Type: <%=order.getResidentialType()%></p>
                       <p class="card-text">Hourly Rate: <%=order.getHourlyRate()%></p>
                       <button class="card-btn" type="submit">Re-order</button>
                   </div>
               </div>
            </form>
            <% } %>
        </div>
    </body>
</html>
