<%-- 
    Document   : order
    Created on : 24/08/2020, 11:49:06 PM
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
                /*margin: 0;*/
                /*padding: 0;*/
                /*display: flex;*/
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                background-color: #24252A;
            }
            
            .container {
                display: flex;
                flex-wrap: wrap;
                justify-content: center;
                /*justify-content: space-between;*/
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
                font-family: Arial, sans-serif;
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
                transition: 0.3s;
            }
            
            .container .box:nth-child(1) .icon {
                box-shadow: 0 0 0 0 #51abff;
                background: #51abff;
                
            }
            
            .container .box:nth-child(1):hover .icon {
                box-shadow: 0 0 0 400px #51abff;
            }
            
            .container .box:nth-child(2) .icon {
                box-shadow: 0 0 0 0 #eccc68;
                background: #eccc68;
                
            }
            
            .container .box:nth-child(2):hover .icon {
                box-shadow: 0 0 0 400px #eccc68;
            }
            
            .container .box:nth-child(3) .icon {
                box-shadow: 0 0 0 0 #1e272e;
                background: #1e272e;                
            }
            
            .container .box:nth-child(3):hover .icon {
                box-shadow: 0 0 0 400px #1e272e;
            }
            
            .container .box .content {
                position: relative;
                transition: 0.1s;
            }
            
            .container .box:hover .content {
                color: #fff;
            }
            
            .content h3 {
                text-align: center;
            }
            
            button {
                border: 0px solid #ecf0f1;
                width: 100%;
                height: 30px;
                background: white;
                transition: 0.5s;
                border-radius: 25px;
                cursor: pointer;
            }
            
            button:hover {
                background: #ecf0f1;
                color: black;
            }
            
            h1 {
                text-align: center;
                font-family: Helvetica, sans-serif;
                color: white;
                margin-top: 3em;
                margin-bottom: 2em;
            }
            
            a {
                width: 73%;
                text-decoration: none;
                height: 20px;
                text-align: center;
                font-family: sans-serif;
                padding: 10px;
                background: #7f8c8d;
                color: white;
                font-weight: 300;
            }
            
            
        </style>
    </head>
    <body>
        
        <h1>Pick A Service That Suits You</h1>
        <!--Start of box-->
        <div class="container">            
            <div class="box">
                <div class="icon">01</div>
                <div class="title">
                    <div class="content">
                        <h3>Rapid Cleaning</h3>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged</p>
                        <button class="btn-book">Book Now <b>(38$/hr)</b></button>
                    </div>
                </div>
            </div>
        <!--End of box-->
        
        <!--Start of box-->
            <div class="box">
                <div class="icon">02</div>
                <div class="title">
                    <div class="content">
                        <h3>Deluxe Cleaning</h3>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged</p>
                        <button class="btn-book">Book Now <b>(50$/hr)</b></button>
                    </div>
                </div>
            </div>
        <!--End of box-->
            
        <!--Start of box-->
            <div class="box">
                <div class="icon">03</div>
                <h4></h4>
                <div class="title">
                    <div class="content">
                        <h3>Premium Cleaning</h3>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged</p>
                        <button class="btn-book">Book Now <b>(90$/hr)</b></button>
                    </div>
                </div>
            </div>
        <!--End of box-->
        
        <a href="home.jsp">Back</a>
        </div>
    </body>
</html>
