<%-- 
    Document   : my-payment-details
    Created on : Oct 21, 2020, 11:49:11 PM
    Author     : David Guntoro
--%>

<%@page import="com.uts.rapid.clean.model.Customer"%>
<%@page import="com.uts.rapid.clean.model.PaymentDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
        ArrayList <PaymentDetail> paymentDetailList = (ArrayList) session.getAttribute("paymentDets");
        Customer customer = (Customer) session.getAttribute("customer");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Payment Details</title>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <link href="css/payment-details.css" rel="stylesheet" type="text/css">
        <script>
            $(function () {
                $("#nav-placeholder").load("navigationbar.jsp");
            });
        </script>
        <style>

        </style>

    </head>
    <body>


        <div id="nav-placeholder"></div>
        <div class="container2">
            Saved Payment Details
            <!-- IF its a null display you dont have any saved credit cards -->
            <% if(paymentDetailList == null){ %>
            <div class="null-content" style="display:flex; text-align: left; margin-top: 40px">
                <img src="css/cc.png">
                <div style="display:flex; padding-left: 70px;"> 
                    You don't have any saved credit cards
                    <br><br>
                   Save your credit or debit card now for express checkout in future rapid clean services. 
                </div>
            </div> 
            
            
            <!-- If paymentDetsList is not empty -->
              <div style="padding-bottom:20px"></div>
              
            <!-- For loop starts here-->
            <% } else { 
                for (PaymentDetail paymentDet : paymentDetailList) {
            %>
            <div class="credit-card" style="display:flex">
                <img src="css/visa.png" width="70px" height="70px">
                <div class="text" style="text-align: left">
                <%=paymentDet.getCardholderName()%>
                <br> 
                <div style="padding-top: 5px;">•••• •••• •••• <%=paymentDet.getLastFourDigits()%> - Expiry Date: <%=paymentDet.getExpiryDate()%></div>
                </div>
                <a href="#"style="margin-left:auto; margin-top:auto; margin-bottom: auto;"><div class="deletebutton">REMOVE</div></a>

            </div>
            
            <% } } %>
            <!-- For loop ends here -->

            <!-- Add payment button -->
            <a href="my-payment-details-add.jsp">
            <div class="container" style="margin-top: 100px">
                <div class="left-side">
                    <div class="card">
                        <div class="card-line"></div>
                        <div class="buttons"></div>
                    </div>
                    <div class="post">
                        <div class="post-line"></div>
                        <div class="screen">
                            <div class="dollar">$</div>
                        </div>
                        <div class="numbers"></div>
                        <div class="numbers-line2"></div>
                    </div>
                </div>
                <div class="right-side">
                    <div class="new">Add Payment</div>

                    <svg class="arrow" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 451.846 451.847"><path d="M345.441 248.292L151.154 442.573c-12.359 12.365-32.397 12.365-44.75 0-12.354-12.354-12.354-32.391 0-44.744L278.318 225.92 106.409 54.017c-12.354-12.359-12.354-32.394 0-44.748 12.354-12.359 32.391-12.359 44.75 0l194.287 194.284c6.177 6.18 9.262 14.271 9.262 22.366 0 8.099-3.091 16.196-9.267 22.373z" data-original="#000000" class="active-path" data-old_color="#000000" fill="#cfcfcf"/></svg>

                </div>
            </div></a>
        </div>

    </body>
</html>
