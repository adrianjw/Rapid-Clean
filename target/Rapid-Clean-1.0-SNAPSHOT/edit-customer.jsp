<%@page import="com.uts.rapid.clean.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
          $(function(){
          $("#nav-placeholder").load("navigationbar.jsp");
          });
        </script>
        <title>My Account</title>
        <link href="css/edituser.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div id="nav-placeholder"></div>
        <header>

        <!-- Identity details -->
        <section class="profileHeader">
          <h1>Hello </h1>
        </section>
        <!-- Links to Social network accounts -->

        </header>
        <!-- content -->
        <section class="mainContent"> 
          <!-- Contact details -->
        <section class="section1">
            <h2 class="sectionTitle">Personal Information</h2>
            <hr class="sectionTitleRule">
            <hr class="sectionTitleRule2">
            <div class="section1Content">
                <p><span>First Name :</span><input style="color: white;" type="text" name="first Name" value=""></p>
                <p><span>Last Name  :</span><input style="color: white;" type="text" name="first Name" value=""></p>
                <p><span>Email      :</span><input style="color: white;" type="text" name="first Name" value=""></p>
                <p><span>Phone      :</span><input style="color: white;" type="text" name="first Name" value=""></p>
            </div>
        </section>
        </section>
        <a href="#"><button class="button" type="submit" value="Update"> Update </button></a>
        <a href="myaccount.jsp"><button class="button"> Go Back </button></a>
    </body>
</html>

