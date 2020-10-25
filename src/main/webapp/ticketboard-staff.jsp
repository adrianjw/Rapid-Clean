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
          $("#nav-placeholder").load("navigationbar.jsp");
          });
        </script>
    </head>
    <body class="ticket__bd">
        
        <!-- Navigation Bar -->
        <div id="nav-placeholder"></div>
        
        <!-- Ticket Sort -->
        <form class="ticket-sort clear center" method="POST" action="TicketStaffServlet">
            <table class="ticket-sort clear center">
                <tr>
                    <td>Status:</td> 
                    <td>
                        <input type="radio" id="unresolved" name="status-ft" value="Unresolved">
                        <label for="unresolved">Unresolved</label><br>
                    </td>
                    <td>
                        <input type="radio" id="in-progress" name="status-ft" value="In-Progress">
                        <label for="in-progress">In-progress</label><br>
                    </td>
                    <td>
                        <input type="radio" id="resolved" name="status-ft" value="Resolved">
                        <label for="resolved">Resolved</label><br>
                    </td>
                </tr>
                <tr>
                    <td>Priority:</td> 
                    <td>
                        <input type="radio" id="high" name="priority-ft" value="High">
                        <label for="high">High</label><br>
                    </td>
                    <td>
                        <input type="radio" id="medium" name="priority-ft" value="Medium">
                        <label for="medium">Medium</label><br>
                    </td>
                    <td>
                        <input type="radio" id="low" name="priority-ft" value="Low">
                        <label for="low">Low</label><br>
                    </td>
                    <td>
                        <input type="radio" id="none" name="priority-ft" value="">
                        <label for="none">None</label><br>
                    </td>
                </tr>
            </table>
            <div class="center" style="width:20%;">
                <button class="ticket-button" type="submit">Apply</button> 
            </div>
        </form>
        
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
                    <form method="POST" action="UpdateTicketServlet?ticketId=<c:out value="${ticket.id}"/>">
                    <tr>
                        <td><c:out value="${ticket.id}"/></td>
                        <td><c:out value="${ticket.department}"/></td>
                        <td><c:out value="${ticket.subject}"/></td>
                        
                        <td style="width: 15%;">
                            <select class="ticket-select" name="status-fd" id="status-fd">
                                <option <c:choose><c:when test="${ticket.status == 'Unresolved'}"> selected="selected" </c:when></c:choose> value="Unresolved">Unresolved</option>
                                <option <c:choose><c:when test="${ticket.status == 'In-Progress'}"> selected="selected" </c:when></c:choose> value="In-Progress">In-Progress</option>
                                <option <c:choose><c:when test="${ticket.status == 'Resolved'}"> selected="selected" </c:when></c:choose> value="Resolved">Resolved</option>
                            </select>
                        </td>
                        
                        <td style="width: 15%;">
                            <select <c:choose>
                                        <c:when test="${ticket.priority == 'High'}"> style="border-left-color: #ff3333; padding-left: 5%;" </c:when>
                                        <c:when test="${ticket.priority == 'Medium'}"> style="border-left-color: #ffff33; padding-left: 5%;" </c:when>
                                        <c:when test="${ticket.priority == 'Low'}"> style="border-left-color: #51abff; padding-left: 5%;" </c:when>
                                    </c:choose> class="ticket-select" name="priority-fd" id="priority-fd">
                                
                                <option <c:choose>
                                            <c:when test="${ticket.priority == 'High'}"> selected="selected" </c:when>
                                        </c:choose> value="High">High</option>
                                <option <c:choose>
                                            <c:when test="${ticket.priority == 'Medium'}"> selected="selected" </c:when>
                                        </c:choose> value="Medium">Medium</option>
                                <option <c:choose>
                                            <c:when test="${ticket.priority == 'Low'}"> selected="selected" </c:when>
                                        </c:choose> value="Low">Low</option>
                                <option <c:choose><c:when test="${ticket.priority == ''}"> selected="selected" </c:when></c:choose> value="">(None)</option>
                            </select>
                        </td>
                        
                        <td><c:out value="${ticket.date}"/></td>
                        <td>
                            <p style="background-color: #1a1a1a; padding-top: 2%;">
                                <button class="ticket-button" type="submit">Update</button>
                                <br><br><a style="text-decoration: none; text-align: center;" class="ticket-link" href="ViewTicketServlet?ticketId=<c:out value="${ticket.id}"/>">View</a>
                            </p>
                        </td>
                    </tr>
                    </form>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
