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
        <% } %>
       
    </body>
</html>
