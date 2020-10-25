<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="ticket__html">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Us!</title>
        <link rel="stylesheet" type="text/css" href="css/ticket-support.css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
            $(function () {
                $("#nav-placeholder").load("navigationbar.jsp");
            });
        </script>
    </head>
    <body class="ticket__bd">
        
        <!-- Navigation Bar -->
        <div id="nav-placeholder"></div>
        
        <h1 class="clear" style="text-align: center;"> Contact Us!</h1>
        
        <div class="clear center" style="width: 70%; text-align: center;"> 
            Need help with your questions or inquiries?
            <br><br>Contact us!
            <br>Phone: 06 3456 2345
            <br>Email: support@rapidclean.com
            <br><br>Or file a ticket below: <br><br>
            <button class="ticket-button"><a style="background-color: #51abff;" href="create-ticket.jsp">Create Ticket</a></button>
            <button class="ticket-button"><a style="background-color: #51abff;" href="TicketCustomerServlet">My Tickets</a></button>
        </div>
        
    </body>
</html>
