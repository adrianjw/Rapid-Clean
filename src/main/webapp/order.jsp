<%-- 
    Document   : order
    Created on : 24/08/2020, 11:49:06 PM
    Author     : trandamtrungthai
--%>

<%@page import="com.uts.rapid.clean.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rapid Clean Services</title>
        <style>
            body {
                margin: 0;
                padding: 0;
            }
            
            .container .box {
                position: relative;
                width: 300px;
                padding: 30px;
                background: #fff;
                box-shadow: 0 5px 15px rgba(0,0,0,.1);
                border-radius: 4px;
                margin: 20px;
                overflow: hidden;
                box-sizing: border-box;
                font-family: Helvetica, sans-serif;
            }
            
            .container {
                display: flex;
                flex-wrap: wrap;
                justify-content: center;
            }
            
            .container .box .icon {
                position: relative;
                width: 80px;
                height: 80px; 
                color: #fff;
                background: #000;
                display: flex; 
                justify-content: center;
                align-items: center;
                border-radius: 50%;
                margin: 0 auto; 
                font-size: 25px;
                font-weight: 700;
                font-family: Helvetica, sans-serif;
                /*transition: 0.3s;*/
            }
            
            .box {
                margin-bottom: 2em;
                /*cursor: pointer;*/
                color: black;
                transition: 0.2s;
            }
            
            .content {
                transition: none !important;
            }
            
            .box:hover {
                background: #51abff;
                color: #fff;    
            }
            
            .box-1:hover {
                background: #eccc68;
                color: #fff;    
            }
            
            .box-2:hover {
                background: #1e272e;
                color: #fff;    
            }
            
            .content {
                height: 200px;
            }
            
            .container .box .icon {
                box-shadow: 0 0 0 0 #51abff;
                background: #51abff;
                
            }
            
/*            .container .box:nth-child(1):hover .icon {
                box-shadow: 0 0 0 400px #51abff;
            }*/
            
            .container .box-1 .icon {
                box-shadow: 0 0 0 0 #eccc68;
                background: #eccc68;
                
            }
            
/*            .container .box:nth-child(2):hover .icon {
                box-shadow: 0 0 0 400px #eccc68;
            }*/
            
            .container .box-2 .icon {
                box-shadow: 0 0 0 0 #1e272e;
                background: #1e272e;                
            }
            
/*            .container .box:nth-child(3):hover .icon {
                box-shadow: 0 0 0 400px #1e272e;
            }*/
            
            .container .box .content {
                position: relative;
                transition: 0.1s;
            }
            
            .container .box:hover .content {
                /*color: #fff;*/
            }            
         
            .content h3 {
                text-align: center;
                margin-top: 1em;
                margin-bottom: 0.5em;
            }
            
            p {
                text-align: center;
            }
            
            .btn-book {
                border: 0px solid #ecf0f1;
                width: 100%;
                height: 33px;
                font-size: 14px;
                font-family: sans-serif;
                background: #fff;
                color: black;
                position: relative;
                justify-content: center;
                text-align: center;
                border-radius: 25px;
                cursor: pointer;
                margin: 0 auto;
                display: inline-block;
            }
            
            .btn-book:hover {
                background-color: white;
            }
            
            h1 {
                text-align: center;
                font-family: Helvetica, sans-serif;
                color: white;
                margin-top: 1em;
                margin-bottom: 1em;
            }
            
            .btn-back a {
                width: 73%;
                position: relative;
            }
            
            .notbutton {
                background: green;
                width: 73%;
                height: 40px;
                padding: 10px;
                position: relative;
                justify-content: center;
                text-align: center;
                margin: 0;
                border-radius: 5px;
            }
            
            .price {
                text-align: center;
                margin-top: 1em;
            }
            
            .price:hover {
                font-weight: 1000;
            }
        </style>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
            $(function(){
            $("#nav-placeholder").load("navigationbar_1.jsp");
             });
        </script>
    </head>
    <body>
        <div id="nav-placeholder">
            
        </div>r
       
        <h1>Pick A Service That Suits You</h1>
        <!--Start of box-->
        <div class="container">
            <form action="OrderServlet" method="post">
                <input type="hidden" name="orderCategory" value="rapid" />
                <input type="hidden" name="orderCategoryDesc" value="Kitchen Cleaning, Bathroom Cleaning, Living Room Cleaning, and Room Cleaning" />
                <input type="hidden" name="hourlyRate" value="38" />
                <div class="box" id="one">
                    <div class="icon">01</div>
                    <div class="title">
                        <div class="content">
                            <h3>Rapid Cleaning</h3>
                            <p>Kitchen Cleaning, Bathroom Cleaning, Living Room Cleaning, and Room Cleaning</p>
                        </div>
                        <button class="btn-book" type="submit">Book Now <b style="background-color: white">(38$/hr)</b></button>
                    </div>
                </div>
            </form>
            
        <!--End of box-->
        
        <!--Start of box-->
        <form action="OrderServlet" method="post">
            <div class="box box-1">
                <input type="hidden" name="orderCategory" value="deluxe" />
                <input type="hidden" name="orderCategoryDesc" value="Floor Cleaning, Window Cleaning, Steam Carpet Cleaning, Kitchen Cleaning,  Bathroom Cleaning, Living Room Cleaning, Room Cleaning, Infection Control and Full House Sanitation." />
                <input type="hidden" name="hourlyRate" value="50"/>
                <div class="icon">02</div>
                <div class="title">
                    <div class="content">
                        <h3>Deluxe Cleaning</h3>
                        <p>Floor Cleaning, Window Cleaning, Steam Carpet Cleaning, Kitchen Cleaning,  Bathroom Cleaning, Living Room Cleaning, Room Cleaning, Infection Control and Full House Sanitation.</p>
                    </div>
                    <button class="btn-book" type="submit">Book Now <b>(50$/hr)</b></button>
                </div>
                
            </div>
        </form>
            
        <!--End of box-->
            
        <!--Start of box-->
        <form action="OrderServlet" method="post">
            <div class="box box-2">
                <input type="hidden" name="orderCategory" value="premium" />
                <input type="hidden" name="orderCategoryDesc" value="Steam carpet cleaning, Kitchen Cleaning,  Bathroom Cleaning, Living Room Cleaning, Room Cleaning, Infection Control and Full House Sanitation" />
                <input type="hidden" name="hourlyRate" value="90"/>
                <div class="icon">03</div>
                <div class="title">
                    <div class="content">
                        <h3>Premium Cleaning</h3>
                        <p>Steam carpet cleaning, Kitchen Cleaning,  Bathroom Cleaning, Living Room Cleaning, Room Cleaning, Infection Control and Full House Sanitation</p>
                    </div>
                    <button class="btn-book" type="submit">Book Now <b>(90$/hr)</b></button>
                </div>
            </div>
        </form>
            
        <!--End of box-->
        
        <a href="home.jsp" class="notbutton"s>Back</a>
        </div>
    </body>
</html>
