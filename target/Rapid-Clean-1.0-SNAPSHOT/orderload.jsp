<%-- 
    To use this loading screen for rapid clean, simply copy and paste
    then modify which servlet u want to take them after 4-5 seconds

    Please make sure u have the rapidcleanloading.css installed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finding your cleaner..</title>
        <link rel="stylesheet" type="text/css" href="css/rapidcleanloading.css">
        <meta http-equiv="refresh" content="3;url=./OrderLoadingServlet"/>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
            .example {
                margin: 25px 100px;
                padding: 0px;
            }

            div.a {
                text-align: center;
            }
            h1 {
                color:#fff;
                font-family: "Montserrat", sans-serif;
                font-size: 18px;
                font-weight: 200;
            }
        </style>
    </head>
    
    <body style="background-color:#24252A">
        <img src="css/logotp.png" class="centerz">
        <div class="example">
            <div class="sk-fold sk-center">
                <div class="sk-fold-cube"></div>
                <div class="sk-fold-cube"></div>
                <div class="sk-fold-cub"></div>
                <div class="sk-fold-cube"></div>
            </div>
        </div>
        <br>
        <div class="a">
            <h1> Please wait while we find your cleaner... </h1>
        </div>
    </body>
</html>
