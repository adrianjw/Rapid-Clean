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
    </head>
    <body class="ticket__bd">
        
        <!-- Navigation Bar -->
        <div id="nav-placeholder"></div>
        
        <!-- Ticket List -->
        <div class="ticketboard-container center clear">
            <table class="ticketboard-tb clear center">
                <tr>
                    <th>ID</th>
                    <th>Department</th>
                    <th>Subject</th>
                    <th>Status</th>
                    <th>Priority</th>
                    <th>Date</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="ticket" items="${listTickets}">
                    <tr>
                        <td><c:out value="${ticket.id}"/></td>
                        <td><c:out value="${ticket.department}"/></td>
                        <td><c:out value="${ticket.subject}"/></td>
                        <td><c:out value="${ticket.status}"/></td>
                        <td><c:out value="${ticket.priority}"/></td>
                        <td><c:out value="${ticket.date}"/></td>
                        <td>
                            <a class="ticket-link clear" href="#">View</a>
                            <br><br><a class="ticket-link clear" href="TicketDeleteServlet?ticketId=<c:out value="${ticket.id}"/>">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </body>
</html>
