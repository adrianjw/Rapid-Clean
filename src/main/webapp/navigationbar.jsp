<%@page import="com.uts.rapid.clean.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/navigationbar.css">
    </head>
    <body>
        <% Customer customer = (Customer) session.getAttribute("customer"); %>
        <div id="sticky">
            <header>
                <img class="logo" src="css/rapidclean-navbar-icon.png" alt ="logo" width="158px" height="50px">
                <nav>
                    <ul class="nav-links">
                        <li class="tab"><a href="home.jsp">Home</a></li>
                        <li class="tab"><a href="order.jsp">Book Now</a></li>
                        <li class="tab"><a href="services.jsp">Services</a></li>
                        <li class="tab"><a href="contact-us.jsp">Contact Us</a></li>
                    </ul>
                </nav>
                <div class="dropdown">
                    <button class="dropdown-button"> MY PROFILE ▼ </button>
                    <div class="dropdown-content">
                        <a href="my-account.jsp">MY ACCOUNT</a>
                        <a href="my-addresses.jsp">MY ADDRESSES</a>
                        <%if (customer != null) {%>
                            <a href="PaymentDetailServlet?customerId=<%=customer.getId()%>">MY PAYMENT DETAILS</a>
                        <%}%>
                        <a href="my-orders.jsp">MY ORDERS</a>
                        <a href="TicketCustomerServlet">MY TICKETS</a>
                        <a href="logout.jsp">LOGOUT</a>
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
