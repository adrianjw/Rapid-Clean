<%@page import="com.uts.rapid.clean.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/order.css">
        <title>Rapid Clean Services</title>
        <style>
            
        </style>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
            $(function(){
            $("#nav-placeholder").load("navigationbar.jsp");
             });
        </script>
    </head>
    <body>
        <div id="nav-placeholder">
            
        </div>
       
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
                            <h3 style="color:#51abff">Rapid Cleaning</h3>
                            <p>Kitchen Cleaning, Bathroom Cleaning, Living Room Cleaning, and Room Cleaning</p>
                        </div>
                        <button class="btn-book" type="submit">Book Now <b>(38$/hr)</b></button>
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
                        <h3 style="color:#eccc68">Deluxe Cleaning</h3>
                        <div class="paragraph">
                            <p>Floor Cleaning, Window Cleaning, Steam Carpet Cleaning, Kitchen Cleaning,  Bathroom Cleaning, Living Room Cleaning, Room Cleaning, Infection Control and Full House Sanitation.</p>
                        </div>
                        
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
                        <h3 style="color:#1e272e">Premium Cleaning</h3>
                        <p>Steam carpet cleaning, Kitchen Cleaning,  Bathroom Cleaning, Living Room Cleaning, Room Cleaning, Infection Control and Full House Sanitation</p>
                    </div>
                    <button class="btn-book" type="submit">Book Now <b>(90$/hr)</b></button>
                </div>
            </div>
        </form>
            
        <!--End of box-->
        
        </div>
        <a href="home.jsp" class="back-btn">Back</a>
    </body>
</html>
