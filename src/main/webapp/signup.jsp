<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
          $(function(){
          $("#nav-placeholder").load("navigationbar.jsp");
          });
        </script>
        <title>Sign Up</title>
    </head>
    <body style="background-color: #51abff">
        <a href="customersignup.jsp"><button class="button button2"> Customer </button></a>
        <a href="cleanersignup.jsp"><button class="button button2"> Cleaner </button></a>
        <a href="index.jsp"><button class="button button2"> Go Back </button></a>
    </body>
</html>
