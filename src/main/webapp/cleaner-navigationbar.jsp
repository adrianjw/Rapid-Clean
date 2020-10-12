<%@page import="com.uts.rapid.clean.model.Cleaner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <% Cleaner cleaner = (Cleaner) session.getAttribute("cleaner"); %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to RapidClean!</title>
        <link rel="stylesheet" href="css/navbar.css">
        <style>
            .sticky {
                position: fixed;
                top: 0;
                width: 100%;
                padding-top: 1px;
                z-index: 1;
            }
        </style>
    </head>
    <body>
        <div id="navbar">
            <header>
                <img class="logo" src="css/logotp.png" alt ="logo" width="10%" height="10%">
                <nav>
                    <ul class="nav__links">
                        <li class="tab"><a href="CleanerOrderServlet?cleanerId=<%=cleaner.getId()%>">Home</a></li>
                        <li class="tab"><a href="#">Earnings</a></li>
                        <li class="tab"><a href="#">Safety Checklist</a></li>
                        <li class="tab"><a href="#">Contact Us</a></li>
                    </ul>
                </nav>
                <div class="dropdown">
                    <a class="cta" href="#"><button>MY PROFILE ⯆</button></a>
                    <div class="dropdown-content" style="right:0">
                        <a href="#">MY ACCOUNT</a>
                        <a href="#">MY PAYMENTS</a>
                        <a href="#">MY JOB HISTORY</a>
                        <a href="ViewRatingServlet">MY RATINGS</a>
                        <a href="LogoutServlet">LOGOUT</a>
                    </div>
                </div>
            </header>
            <hr>
        </div>
        <script>
            window.onscroll = function () {
                myFunction();
            };

            var navbar = document.getElementById("navbar");
            var sticky = navbar.offsetTop;

            function myFunction() {
                if (window.pageYOffset >= sticky) {
                    navbar.classList.add("sticky");
                } else {
                    navbar.classList.remove("sticky");
                }
            }
        </script>
    </body>
</html>
