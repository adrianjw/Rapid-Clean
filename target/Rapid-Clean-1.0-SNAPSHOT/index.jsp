<%@page import="com.uts.rapid.clean.model.Cleaner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
        Cleaner cleaner = new Cleaner ("5f69e1da84ebe990acfef9d6", "Bryan", "Guntoro", "asd@asd.com", "password123", "0412341234", 123456, 123456, "Bryan Guntoro");
        %>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/rapidclean.css" rel="stylesheet" type="text/css">
        <title>Welcome to Rapid Clean!</title>
    </head>
    <body style="background-color: #51abff">
        <img src="css/offwhite.png" class="centerimg">
        <table class="noborders" cellspacing="0" cellpadding="0">
            <tr>
                <td> <img src="css/cleaners.png" class="centerimg2"> </td>
                <td style="margin-bottom:200px">
                    <h1> Hi there! </h1>
                    <h2 class="sub"> Are you looking for cleaners to be at your doorstep as soon as possible? <br>
                        Become a member & book one of the rapid cleaners at your area now! </h2> <br>
                    <a href="login.jsp"><button class="button button2"> Log In </button></a>
                    <a href="signup.jsp"><button class="button button2"> Sign Up </button></a>
                </td>
            </tr>        
        </table>
        <p> Login as Cleaner <a href="CleanerOrderServlet?cleanerId=<%=cleaner.getId()%>">here</a> </p>
        <jsp:include page="/CLearSessionServlet" flush="true"/>
    </body>
</html>
