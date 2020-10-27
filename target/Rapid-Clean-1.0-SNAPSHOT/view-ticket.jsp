<%@page import="com.uts.rapid.clean.model.*"%>
<%@page import="java.util.Date"%>
<%@page import="com.uts.rapid.clean.model.Ticket"%>
<%@page import="org.bson.types.ObjectId"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="ticket__html">
    <head>
        <%
            Ticket ticket = (Ticket) session.getAttribute("ticket");
            Customer customer = (Customer) session.getAttribute("customer");
            Cleaner cleaner = (Cleaner) session.getAttribute("cleaner");
            ObjectId ticketId = new ObjectId();
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Ticket</title>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <link rel="stylesheet" type="text/css" href="css/ticket-support.css"/>
        <% if (customer != null) { %>
            <script>
              $(function(){
              $("#nav-placeholder").load("navigationbar.jsp");
              });
            </script>
        <% } else if (cleaner != null) { %>
            <script>
              $(function(){
              $("#nav-placeholder").load("cleaner-navigationbar.jsp");
              });
            </script>
        <% } else { %>
            
        <% } %>
    </head> 
    <body class="ticket__bd">
        
        <!-- Navigation Bar -->
        <div id="nav-placeholder"></div>
        
        <!-- Ticket View/Details -->
        <div class="ticket-form center">
                <h1 class="clear">Ticket</h1>
                <h1 class="clear">ID: <%= ticket.getId() %></h1> <%= ticket.getStatus() %>
                <p class="clear"><%= ticket.getDate() %></p>
                <table class="ticket-tb clear">
                    <tr>
                        <td style="text-align: left; color: #51abff;">Department: </td>
                        <td align="right"><%= ticket.getDepartment() %></td>    
                    </tr>
                    <tr>
                        <td style="text-align: left; color: #51abff;">Subject: </td>
                        <td align="right"><%= ticket.getSubject() %></td>
                    </tr>
                </table>
                <p class="clear text-color">Description:</p> 
                <p class="clear"><%= ticket.getComment() %></p>
                
                <% if ( customer != null ) { %>
                    <p style="background-color: #1a1a1a; padding-top: 2%;">
                       <a class="clear" href="TicketCustomerServlet"><button class="ticket-button">Back</button></a>
                    </p>
                <% } else if ( cleaner != null ) { %>
                    <p style="background-color: #1a1a1a; padding-top: 2%;">
                       <a class="clear" href="TicketCleanerServlet"><button class="ticket-button">Back</button></a>
                    </p>
                <%} else {%>
                    <p style="background-color: #1a1a1a; padding-top: 2%;">
                       <a class="clear" href="TicketStaffServlet"><button class="ticket-button">Back</button></a>
                    </p>
                <% } %>
        </div>
    </body>
</html>
