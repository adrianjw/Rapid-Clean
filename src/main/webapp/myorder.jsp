<%-- 
    Document   : orderhistory
    Created on : 27/08/2020, 1:44:27 PM
    Author     : trandamtrungthai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
        <style>
/*            body {
                background-color: #24252A;
            }*/
            
            .container {
                border-spacing: 1em;
                text-align: center;
                display: flex;
                justify-content: center;
            }
            
            h1 {
                text-align: center;
                color: white;
                margin-top: 1em;
                margin-bottom: 2em;
            }
                        
            .card-btn {
                color: black;
                background-color: #ff7675;
                transition: none;
                text-align: center;
                padding: 8px 18px;
                border-radius: 5px;
                margin-top: 1em;
                margin-left: 0px;
                font-size: 15px;
                font-family: Helvetica, sans-serif;
            }
            
            .btn-back {
                text-align: center;
                padding: 10px;
                background: blue;
                text-decoration: none;
                color: white;
                margin-top: 2em;
            }
            
            .btn {
                margin: 0 auto;
                margin-top: 2em;
                margin-left: 2em;
            }
        </style>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
            $(function(){
            $("#nav-placeholder").load("navigationbar.jsp");
             });
        </script>
    </head>
    <body>
        <div id="nav-placeholder"></div>
        <div class="container">            
            <form action="OrderPayServlet" method="get">
                <button class="card-btn btn" type="submit">View unpaid order</button>
            </form>
            
            <form action="OrderHistoryServlet" method="get">
                <button class="card-btn btn" type="submit">Order History</button>
            </form>           
            
        </div>
    </body>
</html>
