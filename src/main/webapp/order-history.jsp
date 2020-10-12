<%@page import="com.uts.rapid.clean.model.Customer"%>
<%@page import="com.uts.rapid.clean.model.dao.OrderDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Order History</title>
        <style>
/*            body {
                background-color: #24252A;
            }*/
            
            .container {
                border-spacing: 1em;
                text-align: center;
            }
            
            h1 {
                text-align: center;
                color: white;
                margin-top: 1em;
                margin-bottom: 1em;
                font-family: sans-serif;
            }
            
            .card {
                margin-bottom: 1.5em;
                padding: 10px;
                margin: 4em;
                width: 40%;
                color: white;
                font-family: sans-serif;
                margin: 0 auto;
                margin-top: 1em;
                text-align: center;
            }
            
            .card-body {
                border: 1px white solid;
                padding: 10px;
                border-radius: 5px;
            }
            
            .card-text {
                margin-top: 0.5em;
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
            <h1>Your Order History</h1>
            <h1>
            <%
                Customer customer = (Customer) session.getAttribute("customer");
                String customerId = customer.getId();
                OrderDAO orderDAO = (OrderDAO) session.getAttribute("orderDAO");
                orderDAO.getOrderList(customerId);
            %>
            </h1>
            <div class="card">
               <div class="card-body">
                   <h4>Body</h4>
                   <p class="card-text">This is a sample text</p>
                   <button class="card-btn">View</button>
               </div>
           </div>
        </div>
    </body>
</html>
