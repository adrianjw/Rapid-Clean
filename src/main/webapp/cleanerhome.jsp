<%@page import="com.uts.rapid.clean.model.dao.AddressDAO"%>
<%@page import="com.uts.rapid.clean.model.dao.AcceptServiceDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.uts.rapid.clean.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome Rapid Cleaner!</title>
        <%
            
        Cleaner cleaner = (Cleaner) session.getAttribute("cleaner");
        AcceptServiceDAO orderManager = (AcceptServiceDAO) session.getAttribute("orderManager");
        ArrayList <Order> orderDet = (ArrayList) session.getAttribute("orderD");
        String orderErr = (String) session.getAttribute("orderErr");
        %>
        

        <link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,400,700,900' rel='stylesheet' type='text/css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.0.2/anime.min.js"></script>
        <script>var ml = {timelines: {}};</script>
        <style>
            body {
                font: 20px "Montserrat", Arial, Helvetica, sans-serif;
                color: #fff;
                text-align: center;
            }

            .moving-letters {
                position:  relative;
                top: 0;
                right: 0;
                left: 0;
                bottom: 0;
                margin-top:300px;
                margin-bottom: auto;
                height: 200px;

            }

            .divbutton a:hover {
                color: #51abff;
                transition: all 0.4s ease 0.1s;

            }

            .divbutton {
                height:500px;
                width:100%;
                animation: mymove 6s;
            }

            @keyframes mymove {
                from {opacity: 0;}
                to {opacity: 100;}
            }

            .bookingsection{
                width:100%;
                height:1975px;
                background-color: #1a1a1a;
            }

            .course {
                background-color: #1a1a1a;
                border-radius: 5px;
                box-shadow: 0px 10px 10px rgba(0,0,0,2);
                display: flex;
                overflow: hidden;
                margin:auto;
                position: relative;
                width: 1200px;;
                max-width: 100%;
                left:0;
                right:0;


                margin-left: auto;
                margin-right: auto;




            }
            .container {
                background-color: #1a1a1a;
                padding-bottom: 100px;

            }

            .course h6 {
                background-color: #51abff;
                letter-spacing: 1px;
                text-transform: uppercase;

            }

            .course h2 {
                letter-spacing: 1px;
                margin: 10px 0;
                background-color: #51abff;
            }

            .preview {
                background: #51abff;
                color: #fff;
                padding: 30px;
                width: 350px;
                position: relative;
            }

            .preview a {
                color: #fff;
                font-size: 12px;
                background-color: #51abff;
                margin-top: 30px;
                text-decoration: none;
            }

            .info {
                padding: 30px;
                position: relative;
                width: 100%;
            }


            .container {
                margin-left: auto;
                margin-right: auto;
            }



            .btn-cont {
                text-align: center;
                margin-top: 50px;

            }
            .btn-cont .btn {
                background-color: #1a1a1a;
                border-radius: 3px;
                position: relative;
                padding: 10px 25px;
                border: 1px solid #3cb371;
                color: #3CB371;
                text-decoration: none;
                font-size: 18px;
                font-family: "Montserrat", sans-serif;
                text-transform: uppercase;
                letter-spacing: 0.1px;
                -webkit-font-smoothing: antialiased;
                max-width: 30px;

            }


            .btn:hover {
                border:0px;
                border:none;
            }
            .btn-cont .btn2 {
                background-color: #1a1a1a;
                border-radius: 3px;
                position: relative;
                padding: 10px 25px;
                border: 1px solid #ff8484;
                color: #3CB371;
                text-decoration: none;
                font-size: 18px;
                font-family: "Montserrat", sans-serif;
                text-transform: uppercase;
                letter-spacing: 0.1px;
                -webkit-font-smoothing: antialiased;
                max-width: 30px;

            }


            .btn2:hover {
                border:0px;
                border:none;
            }
            .btn-cont .btn:hover .line-1 {
                -webkit-animation: move1 1500ms infinite ease;
                animation: move1 1500ms infinite ease;
            }
            .btn-cont .btn:hover .line-2 {
                -webkit-animation: move2 1500ms infinite ease;
                animation: move2 1500ms infinite ease;
            }
            .btn-cont .btn:hover .line-3 {
                -webkit-animation: move3 1500ms infinite ease;
                animation: move3 1500ms infinite ease;
            }
            .btn-cont .btn:hover .line-4 {
                -webkit-animation: move4 1500ms infinite ease;
                animation: move4 1500ms infinite ease;
            }

            .btn-cont .btn2:hover .line-1 {
                -webkit-animation: move1 1500ms infinite ease;
                animation: move1 1500ms infinite ease;
            }
            .btn-cont .btn2:hover .line-2 {
                -webkit-animation: move2 1500ms infinite ease;
                animation: move2 1500ms infinite ease;
            }
            .btn-cont .btn2:hover .line-3 {
                -webkit-animation: move3 1500ms infinite ease;
                animation: move3 1500ms infinite ease;
            }
            .btn-cont .btn2:hover .line-4 {
                -webkit-animation: move4 1500ms infinite ease;
                animation: move4 1500ms infinite ease;
            }
            .btn-cont .line-1 {
                content: "";
                display: block;
                position: absolute;
                width: 1px;
                background-color: #3CB371;
                left: 0;
                bottom: 0;
            }
            .btn-cont .line-2 {
                content: "";
                display: block;
                position: absolute;
                height: 1px;
                background-color: #3CB371;
                left: 0;
                top: 0;
            }
            .btn-cont .line-3 {
                content: "";
                display: block;
                position: absolute;
                width: 1px;
                background-color: #3CB371;
                right: 0;
                top: 0;
            }
            .btn-cont .line-4 {
                content: "";
                display: block;
                position: absolute;
                height: 1px;
                background-color: #3CB371;
                right: 0;
                bottom: 0;
            }

            @-webkit-keyframes move1 {
                0% {
                    height: 100%;
                    bottom: 0;
                }
                54% {
                    height: 0;
                    bottom: 100%;
                }
                55% {
                    height: 0;
                    bottom: 0;
                }
                100% {
                    height: 100%;
                    bottom: 0;
                }
            }

            @keyframes move1 {
                0% {
                    height: 100%;
                    bottom: 0;
                }
                54% {
                    height: 0;
                    bottom: 100%;
                }
                55% {
                    height: 0;
                    bottom: 0;
                }
                100% {
                    height: 100%;
                    bottom: 0;
                }
            }
            @-webkit-keyframes move2 {
                0% {
                    width: 0;
                    left: 0;
                }
                50% {
                    width: 100%;
                    left: 0;
                }
                100% {
                    width: 0;
                    left: 100%;
                }
            }
            @keyframes move2 {
                0% {
                    width: 0;
                    left: 0;
                }
                50% {
                    width: 100%;
                    left: 0;
                }
                100% {
                    width: 0;
                    left: 100%;
                }
            }
            @-webkit-keyframes move3 {
                0% {
                    height: 100%;
                    top: 0;
                }
                54% {
                    height: 0;
                    top: 100%;
                }
                55% {
                    height: 0;
                    top: 0;
                }
                100% {
                    height: 100%;
                    top: 0;
                }
            }
            @keyframes move3 {
                0% {
                    height: 100%;
                    top: 0;
                }
                54% {
                    height: 0;
                    top: 100%;
                }
                55% {
                    height: 0;
                    top: 0;
                }
                100% {
                    height: 100%;
                    top: 0;
                }
            }
            @-webkit-keyframes move4 {
                0% {
                    width: 0;
                    right: 0;
                }
                55% {
                    width: 100%;
                    right: 0;
                }
                100% {
                    width: 0;
                    right: 100%;
                }
            }
            @keyframes move4 {
                0% {
                    width: 0;
                    right: 0;
                }
                55% {
                    width: 100%;
                    right: 0;
                }
                100% {
                    width: 0;
                    right: 100%;
                }
            }

        </style>

        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
            $(function () {
                $("#nav-placeholder").load("cleanernavigationbar.jsp");
            });
        </script>

    </head>
    <body>
        <div id="nav-placeholder">
        </div>

        <div class="moving-letters">
            <h1 class="ml11">
                <span class="text-wrapper">
                    <span class="line line1"></span>
                    <span class="letters">Welcome <%=cleaner.getFirstName()%></span> <!--customer.getName() -->
                </span>
            </h1>

            <link rel="stylesheet" href="css/cleanerpages.css">

            <script>
                // Wrap every letter in a span
                $('.ml11 .letters').each(function () {
                    $(this).html($(this).text().replace(/([^\x00-\x80]|\w)/g, "<span class='letter'>$&</span>"));
                });

                ml.timelines["ml11"] = anime.timeline({loop: true})
                        .add({
                            targets: '.ml11 .line',
                            scaleY: [0, 1],
                            opacity: [0.5, 1],
                            easing: "easeOutExpo",
                            duration: 700
                        })
                        .add({
                            targets: '.ml11 .line',
                            translateX: [0, document.querySelector('.ml11 .letters').getBoundingClientRect().width + 10],
                            easing: "easeOutExpo",
                            duration: 700,
                            delay: 100
                        }).add({
                    targets: '.ml11 .letter',
                    opacity: [0, 1],
                    easing: "easeOutExpo",
                    duration: 600,
                    offset: '-=775',
                    delay: (el, i) => 34 * (i + 1)
                }).add({
                    targets: '.ml11',
                    opacity: 0,
                    duration: 1000,
                    easing: "easeOutExpo",
                    delay: 1000
                });
            </script>


        </div>

        <div class="divbutton"><a href="#positioned"> START ACCEPTING BOOKINGS </a> </div>


        <!-- Accept Bookings or Service Section -->
        <div class="bookingsection">

            <!-- Div to cover the navbar height -->
            <div style="width:100%; height:230px"></div>
            <div style="width:100%; height:50px; background-color:#1a1a1a;"></div>

            <h1 style="background-color: #1a1a1a"> Current Orders Available: </h1>
            <br>
            <br>
            <br>
            <br>
            <% 
              if (orderDet != null) { 
            %>
            <% for (Order orderList : orderDet) {
            AcceptServiceDAO temp = new AcceptServiceDAO();
            Customer customer = temp.findCustomer(orderList.getCustomer_id());
            Address address = temp.address(orderList.getAddress_id());
            %>
            


            <!-- Order list starts here, iterate forLoops -->
            <div class="container">
                <div class="course">
                    <div class="preview">
                        <h6> ORDER #<%=orderList.getId()%> </h6>
                        <h2><img src="css/iconclean.png" height="125px" style="background-color: #51abff"></h2>
                        <a> <%=orderList.getDateTime()%> </a>

                    </div>
                    <div class="info">
                        <div class="progress-wrapper">
                            <div class="progress">

                            </div>

                            <h6 style="background-color: #24252A; text-align: left">Customer: <%=customer.getFirstName()%> <%=customer.getLastName()%>  </h6> 
                            <h2  style="background-color: #24252A; text-align: left; text-transform: uppercase"> <%=orderList.getOrderCategory()%> </h2>
                            <h6 style="background-color: #24252A; text-align: left">Hourly Rate: $<%=orderList.getHourlyRate()%>/hr <br> Residential type: <%=orderList.getResidentialType()%>
                                <br> 
                               
                                Address:  <%=address.getFullAddress()%><br> 
                                

                                Cleaning Involved: <%=orderList.getOrderCategoryDesc()%>
                            </h6>
                        </div>
                        <div class='btn-cont' style="text-align:left;">
                            <a class='btn' href="CleanerOrderAcceptedServlet?cleanerId='<%=cleaner.getId()%>'&orderId='<%=orderList.getId()%>'&customerId='<%=orderList.getCustomer_id()%>'"  style="color: #3CB371">
                                Accept Order
                                <span class='line-1'></span>
                                <span class='line-2'></span>
                                <span class='line-3'></span>
                                <span class='line-4'></span>
                            </a>
                            &nbsp;
                            &nbsp;
                            &nbsp;

                            <a class='btn2' href='#' style="color: #FF8484;">
                                Reject Order
                                <span class='line-1' style="background-color: #FF8484"></span>
                                <span class='line-2'style="background-color: #FF8484"></span>
                                <span class='line-3'style="background-color: #FF8484"></span>
                                <span class='line-4'style="background-color: #FF8484"></span>
                            </a>



                        </div>

                    </div>
                </div>
            </div>
            <!-- Order Lists Ends here -->
            <% } } else {%>
            <h1 style="background-color: #1a1a1a"> Sorry! There are no current orders available. </h1>
            <% } %>
        </div>
        <script>
            $("a").click(function () {
                $('html, body').animate({
                    scrollTop: $(".bookingsection").offset().top},
                        'fast');
            });
        </script>
    </body>
</html>