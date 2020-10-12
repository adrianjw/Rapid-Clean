<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Form</title>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
            $(function(){
            $("#nav-placeholder").load("navigationbar_1.jsp");
             });
        </script>
        <style>
            .container {
                font-family: Helvetica, sans-serif;
                color: #fff;
                margin-top: 1em;
                padding: 20px;
                /*text-align: center;*/
            }
            
            input {
                height: 30px;
                width: 50%;
                font-size: 15px;
            }
            
            .form {
/*                border: 1px solid white;
                text-align: center;
                position: relative;
                justify-content: center;
                margin: auto;
                display: inline-block;
                text-align: left;
                margin-left: 24em;
                margin: 0 auto;
                width: 60%;
                padding-left: 16em;*/
                margin-left: 27em;
            }
            
            select {
                width: 150px;
                height: 30px;
                font-size: 15px;
            }
            
            h1 {
                /*text-align: center;*/
                margin-bottom: 0.5em;
            }
            
            .input-field {
                margin-bottom: 1em;
            }
            
            p {
                font-size: 16px;
            }
                       
            .btn-submit {
                margin: 0 auto;
                background-color: #34495e;
                border-radius: 5px;
                width: 50%;
            }
            
            .btn-submit:hover {
                background-color: #2c3e50;
            }
            
            .btn-cancel {
                background-color: #95a5a6;
                transition: 0.1s;
                width: 50%;                
                border-radius: 5px;
                margin: 0 auto;
                margin-top: 1em;
            }
            
            .btn-cancel:hover {
                background-color: #bdc3c7;
            }
            
           
        </style>
    </head>
    <body>
        <% String orderCategory = request.getParameter("orderCategory");
           String hourlyRate = request.getParameter("hourlyRate");
           String orderCategoryDesc = request.getParameter("orderCategoryDesc");
        %>
        <div id="nav-placeholder"></div>
        <div class="container">
            <!--Start of form--> 
            <div class="form">
                <form action="OrderFormServlet" method="post">
                    <h1>Order Form</h1>
                    <input type="hidden" name="orderCategoryDesc" value="<%= orderCategoryDesc %>" />
                    <div class="input-field">
                        <p>Service</p>
                        <input type="text" name="orderCategory" value="<%= orderCategory.toUpperCase()%> CLEANING" readonly>
                    </div>
                    <div class="input-field">
                        <p>Price per hour</p>
                        <input type="text" name="hourlyRate" value=<%= hourlyRate %> readonly>
                    </div>
                    <div class="input-field">
                        <p>Street Address</p>
                        <input type="text" name="streetAddress">
                    </div>
                    <div class="input-field">
                        <p>Suburb</p>
                        <input type="text" name="suburb">
                    </div>
                    <div class="input-field">
                        <p>State</p>
                        <input type="text" name="state">
                    </div>
                    <div class="input-field">
                        <p>Postcode</p>
                        <input type="text" name="postcode">
                    </div>
                    <div class="input-field">
                        <p>Type of resident</p>
                        <select name="residentialType">    
                            <option value="Apartment">Apartment</option>
                            <option value="House">House</option>
                            <option value="Building">Building</option>
                            <option value="Dorm">Dorm</option>
                            <option value="Studio">Studio</option>
                        </select>
                    </div>
                    <button class="btn-submit" type="submit">Submit</button> <br/>
                </form>
                <button class="btn-cancel" onclick="location.href='order.jsp'">Cancel</button>
                <!--End of form-->
            </div>
        </div>
    </body>
</html>
