<%-- 
    Document   : cleanerorderaccepted
    Created on : Aug 22, 2020, 10:01:00 PM
    Author     : David Guntoro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
            $(function () {
                $("#nav-placeholder").load("cleanernavigationbar.jsp");
            });
        </script>
        <title>Order #12371231ADAS</title> <!-- order.getId() -->
    </head>
    <body>
         <div id="nav-placeholder">
        </div>
        
        <button> <a href="cleanerordercompleted.jsp"> Finish </a> </button>
    </body>
</html>
