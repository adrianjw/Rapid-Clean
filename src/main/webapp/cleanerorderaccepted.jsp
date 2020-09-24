<%-- 
    Document   : cleanerorderaccepted
    Created on : Aug 22, 2020, 10:01:00 PM
    Author     : David Guntoro
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.uts.rapid.clean.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            Order orderAccepted = (Order) session.getAttribute("orderAccepted");
            Customer customer = (Customer) session.getAttribute("customer");
            Cleaner cleaner = (Cleaner) session.getAttribute("cleaner");
            Address address = (Address) session.getAttribute("address");
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            String date = DATE_FORMAT.format(orderAccepted.getDateTime());

        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
            $(function () {
                $("#nav-placeholder").load("cleanernavigationbar.jsp");
            });
        </script>

        <title>Order #<%=orderAccepted.getId()%></title>
        <style>

            body {
                font: 20px "Montserrat", Arial, Helvetica, sans-serif;
                color: #fff;
                text-align: center;
            }
            .course {
                background-color: #24252A;
                border-radius: 5px;
                box-shadow: 5px 10px 10px rgba(1,0,0,2);
                display: flex;
                overflow: hidden;
                margin:auto;
                position: relative;
                width: 1200px;;
                max-width: 100%;
                left:0;
                right:0;


                margin-left: auto;
                margin-right: auto;




            }
            .container {
                background-color: #24252a;
                padding-bottom: 70px;
                padding-top: 10px;

            }

            .course h6 {
                background-color: #51abff;
                letter-spacing: 1px;
                text-transform: uppercase;

            }

            .course h2 {
                letter-spacing: 1px;
                margin: 10px 0;
                background-color: #51abff;
            }

            .preview {
                background: #51abff;
                color: #fff;
                padding: 30px;
                width: 350px;
                position: relative;
            }

            .preview a {
                color: #fff;
                font-size: 12px;
                background-color: #51abff;
                margin-top: 30px;
                text-decoration: none;
            }

            .info {
                padding: 30px;
                position: relative;
                width: 100%;
            }


            .container {
                margin-left: auto;
                margin-right: auto;
            }

            table.center {
                margin-left:auto; 
                margin-right:auto;

            }

            .no-outline:focus {
                outline: none;
            }

            table, tr, td{
                text-align: center;
                border-color: #fff;
                padding:10px;
                padding-top: 2px;
                color: #fff;

            }

            input [type=time] {
                color: #fff;


            }

            input {
                border-top-style: hidden;
                border-right-style: hidden;
                border-left-style: hidden;
                border-bottom-style: groove;
                width: 110px;
                color: #fff;
                font-family: Montserrat, Arial;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div id="nav-placeholder">
        </div>
        <!-- Obtain the customer details from the customer_id provided in the order-->
        <h1 style="text-transform: uppercase; font-size: 35px; padding-top: 50px; padding-bottom: 30px;"> Order #<%=orderAccepted.getId()%> ACCEPTED</h1>
        <hr>
        <br>
        <br>
        <div class="container">
            <div class="course">
                <div class="preview">
                    <h6> ORDER #<%=orderAccepted.getId()%></h6>
                    <h2><img src="css/iconclean.png" height="125px" style="background-color: #51abff"></h2>
                    <a> <%=date%> </a>

                </div>
                <div class="info">
                    <div class="progress-wrapper">
                        <div class="progress">

                        </div>

                        <h6 style="background-color: #24252A; text-align: left">Customer: <%=customer.getFirstName()%> <%=customer.getLastName()%> </h6> 
                        <h2  style="background-color: #24252A; text-align: left; text-transform: uppercase"> <%=orderAccepted.getOrderCategory()%> </h2>
                        <h6 style="background-color: #24252A; text-align: left">Hourly Rate: $<%=orderAccepted.getHourlyRate()%>/hr <br> Residential type: <%=orderAccepted.getResidentialType()%> <br> Address: <%=address.getFullAddress()%> <br> 

                            Cleaning Involved: <%=orderAccepted.getOrderCategoryDesc()%>
                        </h6>

                        <h6 style="background-color: #24252A; text-align: left; padding-top: 25px;"> Call <%=customer.getFirstName()%>: <%=customer.getPhone()%> </h6>
                    </div>




                </div>
            </div>
        </div>
        <form action="welcome.jsp" method="post" action="CleanerOrderCompletedServlet?cleanerId=<%=cleaner.getId()%>&orderId=<%=orderAccepted.getId()%>" style="color: #Fff">


            <table class="center">
                <tr style="border-color: #24252A"><td style="border-top: 0px; font-size: 18px; text-transform: uppercase;"> Start Time </td> <td style="font-size: 18px; text-transform: uppercase;"> End Time </td> </tr>
                <tr><td><input type="time" style="color:#fff" class="no-outline" name="startTime" required></td>

                    <td> <input type="time" class="no-outline" name="endTime" style="color:#fff"  required></td></tr>            
            </table>

            <p style="text-transform: uppercase; font-size: 12px; padding-bottom: 20px;"> *WARNING! Faking Start Time and End Time will result in serious sanctions </p>


            <p style="padding-bottom: 25px;"> <img src="css/inprogress.gif" width="In P35px" height="35px" >  Status: In Progress  </p> 
            <button type="submit" value="Finish"> Finish  </button>
        </form>

    </body>
</html>
