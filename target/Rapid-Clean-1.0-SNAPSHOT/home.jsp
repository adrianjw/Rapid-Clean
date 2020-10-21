<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
            $(function () {
                $("#nav-placeholder").load("navigationbar.jsp");
            });
        </script>

        <style>            
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


            *
            {
                background-color: transparent;
            }
            .container {
                position: relative;
                text-align: center;
                color: white;
                background-color: #f8f8f8;
                font-family: "Montserrat";
                font-size: 28px;



            }

            .top-left { 
                position: absolute;
                top: 290px;
                left: 550px;
            }

            .top-left2 { 
                position: absolute;
                top: 590px;
                left: 550px;
            }

            .top-left3 { 
                position: absolute;
                top: 690px;
                left: 530px;
            }

        </style>
    </head>
    <body>
        <div id="nav-placeholder"></div>
        <div class="container">
            <img src="css/customer-home.jpg" width="100%" height="100%" style="z-index:1">
            <div class="top-left"><h1 style="background-color: #e4e5ea; color: #24252A; text-align: left;"> Australia's No. 1 <br> Marketplace for <br> Professional Home <br> Online-based Cleaning </h1></div>
            <div class="top-left2"><h1 style="background-color: #efeef4; color: #51abff; font-size: 27px;"> 100% Satisfaction Guarantee </h1></div>
            <button class="top-left3"> Book Now </button>


    </body>
</html>
