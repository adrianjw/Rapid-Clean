<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/address-mgmt.css" rel="stylesheet" type="text/css">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
          $(function(){
          $("#nav-placeholder").load("navigationbar.jsp");
          });
        </script>
        <title>My Addresses</title>
    </head>
    <body>
        <div id="nav-placeholder"></div>
        <div class="main-div">
            <h1> My Addresses </h1>
            <a href="create-address.jsp"><button class="add-address-button"><span>+</span><br>Add address</button></a>
        </div>
    </body>
</html>
