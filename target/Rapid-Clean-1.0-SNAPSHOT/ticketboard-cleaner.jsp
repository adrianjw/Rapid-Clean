<%@page import="com.uts.rapid.clean.model.Cleaner"%>
<%@page import="com.uts.rapid.clean.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html class="ticket__html">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Ticketboard</title>
        <link rel="stylesheet" type="text/css" href="css/ticket-support.css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
          $(function(){
          $("#nav-placeholder").load("cleaner-navigationbar.jsp");
          });
        </script>
        <%
            Cleaner cleaner = (Cleaner) session.getAttribute("cleaner");
        %>
    </head>
    <body class="ticket__bd">
        
        <!-- Navigation Bar -->
        <div id="nav-placeholder"></div>
        
        <!-- Customer Details -->
        <div class="ticketboard-container center clear">
            
            <h1 class="clear"><%= cleaner.getFirstName() %> <%= cleaner.getLastName() %></h1>
            <p class="clear">
                ID: <%= cleaner.getId() %>
                <br>E-mail: <%= cleaner.getEmail() %>
            </p>
            
            <p class="clear">
                To contact staff for inquires and issues, please file a ticket. Any tickets filed may also be viewed or cancelled below.
            </p>
            
            <p class="clear" style="float:right;"><a class="clear" href="create-ticket.jsp"><button>Create Ticket</button></a></p>

            <!-- Ticket List -->
            <table class="ticketboard-tb clear center">
                <tr>
                    <th>ID</th>
                    <th>Department</th>
                    <th>Subject</th>
                    <th>Status</th>
                    <th>Date</th>
                    <th>Action</th>
                </tr>
                 <c:forEach var="ticket" items="${listTickets}">
                    <tr>
                        <td><c:out value="${ticket.id}"/></td>
                        <td><c:out value="${ticket.department}"/></td>
                        <td><c:out value="${ticket.subject}"/></td>
                        <td><c:out value="${ticket.status}"/></td>
                        <td><c:out value="${ticket.date}"/></td>
                        <td>
                            <a class="ticket-link clear" href="ViewTicketServlet?ticketId=<c:out value="${ticket.id}"/>">View</a>
                            <br><br><a class="ticket-link clear" href="DeleteTicketServlet?ticketId=<c:out value="${ticket.id}"/>">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            
        </div>
    </body>
</html>
