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
            body {
                background-color: #24252A;
            }
            
            .container {
                border-spacing: 1em;
            }
            
            h1 {
                text-align: center;
                color: white;
                margin-top: 1em;
                margin-bottom: 2em;
            }
            
            .card {
                margin-bottom: 1.5em;
                
            }
            
            .btn-back {
                text-align: center;
                padding: 10px;
                background: blue;
                text-decoration: none;
                color: white;
                margin-top: 2em;
            }
        </style>
        
        <script>
            $(function(){
            $("#nav-placeholder").load("navigationbar.jsp");
             });
        </script>
    </head>
    <body>
        <div id="nav-placeholder">
            
        </div>
        <a class="btn-back" href="home.jsp">Go back</a>
        <h1>Order History</h1>
        <div class="container">
            
            <div class="card">
                <div class="card-header">
                  <b>Deluxe Cleaning</b>
                </div>
                <div class="card-body">
                  <h5 class="card-title">02/07/2020</h5>
                  <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                  <a href="#" class="btn btn-primary">View Details</a>
                </div>
            </div>
            
            <div class="card">
                <div class="card-header">
                    <b>Deluxe Cleaning</b>
                </div>
                <div class="card-body">
                  <h5 class="card-title">01/06/2020</h5>
                  <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                  <a href="#" class="btn btn-primary">View Details</a>
                </div>
            </div>
            
            <div class="card">
                <div class="card-header">
                  <b>Deluxe Cleaning</b>
                </div>
                <div class="card-body">
                  <h5 class="card-title">14/05/2020</h5>
                  <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                  <a href="#" class="btn btn-primary">View Details</a>
                </div>
            </div>
            
            <div class="card">
                <div class="card-header">
                  <b>Deluxe Cleaning</b>
                </div>
                <div class="card-body">
                  <h5 class="card-title">07/02/2020</h5>
                  <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                  <a href="#" class="btn btn-primary">View Details</a>
                </div>
            </div>
            
        </div>
    </body>
</html>
