<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/navbar.css">
    </head>
    <body>
        <div id="sticky">
            <header>
                <img class="logo" src="css/logotp.png" alt ="logo" width="158px" height="50px">
                <nav>
                    <ul class="nav-links">
                        <li class="tab"><a href="home.jsp">Home</a></li>
                        <li class="tab"><a href="order.jsp">Book Now</a></li>
                        <li class="tab"><a href="services.jsp">Services</a></li>
                        <li class="tab"><a href="#">Contact Us</a></li>
                    </ul>
                </nav>
                <div class="dropdown">
                    <button class="dropdown-button"> MY PROFILE ▼ </button>
                    <div class="dropdown-content">
                        <a href="my-account.jsp">MY ACCOUNT</a>
                        <a href="my-addresses.jsp">MY ADDRESSES</a>
                        <a href="#">MY PAYMENT DETAILS</a>
                        <a href="my-orders.jsp">MY ORDERS</a>
                        <a href="LogoutServlet">LOGOUT</a>
                    </div>
                </div>
            </header>
            <hr>
        </div>
        <script>
            var navbar = document.getElementById("navbar");
            var sticky = navbar.offsetTop;
            
            window.onscroll = function() {
                if (window.pageYOffset >= sticky) {
                    navbar.classList.add("sticky");
                }
                else {
                    navbar.classList.remove("sticky");
                }
            };
        </script>
    </body>
</html>
