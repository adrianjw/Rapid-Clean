<%@page import="com.uts.rapid.clean.model.Order"%>
<%@page import="com.uts.rapid.clean.model.OrderAccepted"%>
<%@page import="com.uts.rapid.clean.model.OrderCompleted"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/card.css">
        <meta http-equiv="refresh" content="5;url=./OrderAcceptedServlet" />
        <title>Home</title>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
          $(function(){
          $("#nav-placeholder").load("navigationbar.jsp");
          });
        </script>
        
        <style>            
            .container {
                border-spacing: 1em;
            }
            
            h1 {
                text-align: center;
                color: white;
                margin-top: 1em;
                margin-bottom: 2em;
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
            
            p {
                color: white;
            }
        </style>
    </head>
    <body>
        <div id="nav-placeholder"></div>
        <%
            OrderCompleted orderCompleted = (OrderCompleted) session.getAttribute("orderCompleted");
            OrderAccepted orderAccepted = (OrderAccepted) session.getAttribute("orderAccepted");
            Order order = (Order) session.getAttribute("order");
        %>
        <% if (orderAccepted != null) {%>
        <p>There is an order, please wait for your order to be completed to pay and book a new one.</p>
        <div class="card">
            <div class="card-body">
                <h4><%=orderAccepted.getId()%></h4>
                <p class="card-text">Service: <%=order.getOrderCategory()%></p>
                <p class="card-text">Residential Type: <%=order.getResidentialType()%></p>
                <p class="card-text">Hourly Rate: <%=order.getHourlyRate()%></p>
                <!--<button class="card-btn">View</button>-->
            </div>
        </div>
        <% } else if (orderAccepted == null && orderCompleted != null) {%>
        <p>Your order is ready. Please click the button to review your order and pay</p>
        <form action="OrderPayServlet" method="get">
            <button class="card-btn" type="submit">Pay</button>
        </form>
        <% } else { %>
        <p>No order yet. Please booked a new order</p>
        <% } %>
       
    </body>
</html>
