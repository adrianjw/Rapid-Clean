<%@page import="com.uts.rapid.clean.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            OrderCompleted orderCompleted = (OrderCompleted) session.getAttribute("orderCompleted");
            Cleaner cleaner = (Cleaner) session.getAttribute("cleaner");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <link href="css/rapidclean.css" rel="stylesheet" type="text/css">
        <script>
            $(function () {
                $("#nav-placeholder").load("cleanernavigationbar.jsp");
            });
        </script>
        <title>Thank You!</title> <!-- order.getId() -->
    </head>
    <body>
        <div id="nav-placeholder">
        </div>

        <h1 style="text-align: center; padding-top: 70px; padding-bottom: 20px"> GREAT! </h1>

        <h1 style="text-align: center; font-weight: lighter  ;font-size: 25px; padding-bottom: 15px; text-transform:uppercase"> Order #<%=orderCompleted.getOrder_id()%> Completed</h1>
        <img src="css/tick_1.png" width="2%" style="margin:auto; margin-left:0 auto; display: flex; max-width: 4%; padding-bottom: 24px"> 
        <p style="font-size: 13px"> Thank you for working as our Rapid Cleaner </p>
        <p style="font-size: 13px"> Your total payout is <b> $<%=orderCompleted.getWorkedHours()%> </b>and is expected to be received by the end of this week </p>
        <div class="btn-cont" style="text-align:center; padding-top: 50px; ">

             <a class='btn' href="cleanerpayments.jsp"">
                VIEW PAYMENTS
                <span class='line-1'></span>
                <span class='line-2'></span>
                <span class='line-3'></span>
                <span class='line-4'></span>
            </a>

        &nbsp;
        &nbsp;
        &nbsp;
        &nbsp;
            <a class='btn2' href="CleanerOrderServlet?cleanerId=<%=cleaner.getId()%>" >
                NEW ORDER
                <span class='line-1' style="background-color: #51abff"></span>
                <span class='line-2'style="background-color: #51abff"></span>
                <span class='line-3'style="background-color: #51abff"></span>
                <span class='line-4'style="background-color: #51abff"></span>
            </a>
           
        </div>
        
        <div style="padding-top: 155px"></div>
        <p style="font-size: 13px;"> Need help with anything or want to report an issue? Click <a href="contactus.jsp" style="font-family: arial; font-size: 12px;"> <u>here</u> </a> </p>
    </body>
</html>
