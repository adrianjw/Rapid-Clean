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
        <title>Login</title>
    </head>
    <body>
        <div id="nav-placeholder"></div>
        <a href="home.jsp"><button class="button button2"> Login </button></a>
        <a href="index.jsp"><button class="button button2"> Go Back </button></a>
    </body>
</html>
