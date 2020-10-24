<%-- 
    Document   : orderhistory
    Created on : 27/08/2020, 1:44:27 PM
    Author     : trandamtrungthai
--%>

<%@page import="com.uts.rapid.clean.model.OrderAccepted"%>
<%@page import="com.uts.rapid.clean.model.Order"%>
<%@page import="com.uts.rapid.clean.model.OrderCompleted"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="7;url=./OrderPayServlet"/>
        <title>Order Pay</title>

        <style>
/*            body {
                background-color: #24252A;
            }*/
            
            .container {
                border-spacing: 1em;
                text-align: center;
            }
            
            h1 {
                text-align: center;
                color: white;
                margin-top: 1em;
                margin-bottom: 2em;
            }
            
            h3 {
                color: white;
            }
            
            .card {
                margin-bottom: 1.5em;
                padding: 10px;
                margin: 4em;
                width: 40%;
                color: white;
                font-family: sans-serif;
                margin: 0 auto;
                margin-top: 1em;
                text-align: center;
            }
            
            .card-body {
                border: 1px white solid;
                padding: 10px;
                border-radius: 5px;
            }
            
            .card-text {
                margin-top: 0.5em;
            }
            
            .card-btn {
                color: black;
                background-color: #ff7675;
                transition: none;
                text-align: center;
                padding: 8px 18px;
                border-radius: 5px;
                margin-top: 1em;
                margin-left: 0px;
                font-size: 15px;
                font-family: Helvetica, sans-serif;
            }
            
            .btn-back {
                text-align: center;
                padding: 10px;
                background: blue;
                text-decoration: none;
                color: white;
                margin-top: 2em;
            }
            
            .btn {
                margin: 0 auto;
            }
        </style>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
            $(function(){
            $("#nav-placeholder").load("navigationbar.jsp");
             });
        </script>
    </head>
    <body>
        <div id="nav-placeholder"></div>
        <% OrderCompleted orderCompleted = (OrderCompleted) session.getAttribute("orderCompleted");
           Order order = (Order) session.getAttribute("order");
        %>
        <div class="container">
        <h3>Your order is ready to be paid.</h3>
        <div class="card">
               <div class="card-body">
                   <c:forEach var="orderCompleted" items="${orderCompleted}">
                       <h4>Order Id: <c:out value="${orderCompleted.order_id}"/></h4>
                       <p class="card-text">Total Price: $<%= orderCompleted.getWorkedHours()%></p>
                       <p class="card-text">Start time: <%= orderCompleted.getStartTime()%></p>
                       <p class="card-text">End time: <%= orderCompleted.getEndTime()%></p>
                       <button class="card-btn" disabled>Pay</button>
                   </c:forEach>
                   
               </div>
           </div>
        </div>
    </body>
</html>
