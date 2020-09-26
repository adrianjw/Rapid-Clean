<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/useraccessmgmt.css" rel="stylesheet" type="text/css">
        <title>Sign Up</title>
    </head>
    <body>
        <h1> Sign Up As</h1>
        <a href="customersignup.jsp"><button class="customer-button"> Customer </button></a>
        <a href="cleanersignup.jsp"><button class="cleaner-button"> Cleaner </button></a>
        <jsp:include page="/CLearSessionServlet" flush="true"/>
    </body>
</html>
