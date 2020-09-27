<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/navbar.css">
        <style>
            .sticky {
                position: fixed;
                top: 0;
                width: 100%;
                z-index: 1;
            }
        </style>
    </head>
    <body>
        <div id="sticky">
            <header>
                <img class="logo" src="css/logotp.png" alt ="logo" width="10%" height="10%">
                <nav>
                    <ul class="nav__links">
                        <li class="tab"><a href="home.jsp">Home</a></li>
                        <li class="tab"><a href="order.jsp">Book Now</a></li>
                        <li class="tab"><a href="services.jsp">Services</a></li>
                        <li class="tab"><a href="#">Contact Us</a></li>
                    </ul>
                </nav>
                <div class="dropdown">
                    <a class="cta" href="#"><button>MY PROFILE ⯆</button></a>
                    <div class="dropdown-content" style="right:0">
                        <a href="myaccount.jsp">MY ACCOUNT</a>
                        <a href="myaddresses.jsp">MY ADDRESSES</a>
                        <a href="#">MY PAYMENT DETAILS</a>
                        <a href="myorder.jsp">MY ORDERS</a>
                        <a href="customerlogout.jsp">LOGOUT</a>
                    </div>
                </div>

            </header>
            <hr>
        </div>
        <script>
            window.onscroll = function () {
                myFunction()
            };

            var navbar = document.getElementById("navbar");
            var sticky = navbar.offsetTop;

            function myFunction() {
                if (window.pageYOffset >= sticky) {
                    navbar.classList.add("sticky")
                } else {
                    navbar.classList.remove("sticky");
                }
            }
        </script>
    </body>
</html>
