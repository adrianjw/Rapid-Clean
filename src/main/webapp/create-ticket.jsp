<%@page import="com.uts.rapid.clean.model.*"%>
<%@page import="org.bson.types.ObjectId"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="ticket__html">
    <head>
        <%
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
        <% } %>
    </head>
    <body class="ticket__bd">
        <!-- Navigation Bar-->
        <div id="nav-placeholder"></div>
        
        <!-- Ticket Create Form: Customer -->
        <div class="ticket-form center">
            <% if ( customer != null ) {%>
            <form style="background-color: #1a1a1a;" method="POST" action="CreateTicketServlet">
                <h1 class="clear" >File a Ticket</h1>
                <p class="clear">Ticket ID: <%= ticketId.toHexString() %></p>
                <input type="hidden" name="ticketId" value="<%= ticketId.toHexString() %>">
                <table class="ticket-tb clear">
                    <tr>
                        <td>Department: </td>
                        <td align="right">
                            <div class="ticket-select">
                                <select name="department">
                                <option value="General Inquiry">General Inquiry</option>
                                <option value="Services">Services</option>
                                <option value="Orders">Orders</option>
                                <option value="Payment & Billing">Payment & Billing</option>
                                <option value="Employment Opportunities">Employment Opportunities</option>
                                <option value="Website">Website</option>
                                <option value="Other">Other</option>
                                </select>
                            </div>
                        </td>    
                    </tr>
                    <tr>
                        <td>Subject: </td>
                        <td align="right"><input id="subject" name="subject" type="text"/></td>
                    </tr>
                </table>
                <p class="clear">Description:</p> 
                <textarea name="comment" class="ticket-description" rows="15"></textarea> 
                <p style="background-color: #1a1a1a; padding-top: 2%;">
                    <button class="ticket-button" type="submit">Submit</button>
                    <a class="clear ticket-link" href="contact-us.jsp">Cancel</a>
                </p>
            </form>
            <% } else if ( cleaner != null ) {%>
            
            <!-- Ticket Create Form: Cleaner -->
            <form style="background-color: #1a1a1a;" method="POST" action="CreateTicketServlet">
                <h1 class="clear" >File a Ticket</h1>
                <p class="clear">Ticket ID: <%= ticketId.toHexString() %></p>
                <input type="hidden" name="cleaner-ticketId" value="<%= ticketId.toHexString() %>">
                <table class="ticket-tb clear">
                    <tr>
                        <td>Department: </td>
                        <td align="right">
                            <div class="ticket-select">
                                <select name="cleaner-department">
                                <option value="General Inquiry">General Inquiry</option>
                                <option value="Services">Services</option>
                                <option value="Orders">Orders</option>
                                <option value="Payment & Billing">Payment & Billing</option>
                                <option value="Website">Website</option>
                                <option value="Other">Other</option>
                                </select>
                            </div>
                        </td>    
                    </tr>
                    <tr>
                        <td>Subject: </td>
                        <td align="right"><input id="subject" name="cleaner-subject" type="text"/></td>
                    </tr>
                </table>
                <p class="clear">Description:</p> 
                <textarea name="cleaner-comment" class="ticket-description" rows="15"></textarea> 
                <p style="background-color: #1a1a1a; padding-top: 2%;">
                    <button class="ticket-button" type="submit">Submit</button>
                    <a class="clear ticket-link" href="TicketCleanerServlet">Cancel</a>
                </p>
            </form>
            <% } %>
        </div>
    </body>
</html>
