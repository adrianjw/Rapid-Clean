<%-- 
    Document   : cleanerorderaccepted
    Created on : Aug 22, 2020, 10:01:00 PM
    Author     : David Guntoro
--%>

<%@page import="com.uts.rapid.clean.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <% Customer customer = (Customer) session.getAttribute("customer"); %>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css">
        <script>
            $(function () {
                $("#nav-placeholder").load("navigationbar.jsp"); // Edit this
            });
        </script>
        
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');

            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: "Montserrat";
            }

            body{

                margin: 0 10px;
            }

            h2{

                background-color: #f8f8f8;

            }

            .payment{
                background: #f8f8f8;
                max-width: 360px;
                margin: 0px auto;
                height: auto;
                padding: 35px;
                padding-top: 70px;
                border-radius: 5px;
                position: relative;

                font-family: "Montserrat";

            }

            .payment h2{
                text-align: center;
                letter-spacing: 2px;
                margin-bottom: 40px;
                color: #24252A;
                font-family: "Montserrat";
                background-color: #f8f8f8;
            }

            .form .label{
                display: block;
                color: #24252A;
                margin-bottom: 6px;
                background-color: #f8f8f8;
            }

            .input{
                padding: 13px 0px 13px 25px;
                width: 100%;
                text-align: center;
                border: 2px solid #dddddd;
                border-radius: 5px;
                letter-spacing: 1px;
                word-spacing: 3px;
                outline: none;
                font-size: 16px;
                color: #24252A;
                font-family: "Montserrat";
                background-color: #f8f8f8;
            }

            .card-grp{
                display: flex;
                justify-content: space-between;
                background-color: #f8f8f8;
            }

            .card-item{
                width: 48%;
                background-color: #fff;
            }

            .space{

            }

            .icon-relative{
                position: relative;
                background-color: #f8f8f8;

            }

            .icon-relative .fas,
            .icon-relative .far{
                position: absolute;
                bottom: 12px;
                left: 15px;
                font-size: 20px;
                color: #24252A;
                background-color: #f8f8f8;


            }

            .btn{

                background: #51abff;
                padding: 12px;
                text-align: center;
                color: #fff;

                cursor: pointer;

            }

            .btn:hover{
                opacity: 0.85;
            }


            .payment-logo{
                position: absolute;
                top: -50px;
                left: 50%;
                transform: translateX(-50%);
                width: 100px;
                height: 100px;
                background: #f8f8f8;
                border-radius: 50%;
                box-shadow: 0 0 5px rgba(0,0,0,0.2);
                text-align: center;
                line-height: 85px;
            }

            .payment-logo:before{
                content: "";
                position: absolute;
                top: 5px;
                left: 5px;
                width: 90px;
                height: 90px;
                background: #5bdc9f;
                border-radius: 50%;

            }

            .payment-logo p{
                position: relative;
                color: #f8f8f8;
                font-size: 58px;

            }

            input:focus::placeholder {
                color: transparent;
            }
            .breaks
            {
                padding-bottom: 20px;
                background-color: #f8f8f8;
            }


            @media screen and (max-width: 420px){
                .card-grp{
                    flex-direction: column;
                }
                .card-item{
                    width: 100%;
                    margin-bottom: 20px;

                }
                .btns{
                    margin-top: 20px;
                    background-color: #5bdc9f;
                }
                .btns:hover
                {
                    opacity: 0.85;
                }
            }
        </style>
        <title>My Payment Details</title> 
    </head>
    <body>
        <div id="nav-placeholder">
        </div>

        <div style="margin-top: 100px;"></div>
        <div class="wrapper">
            <div class="payment">
                <div class="payment-logo">
                    <img src="css/secure-payment.png" width="60px" height="60px" style="z-index: 100; position: relative; background-color: #5bdc9f; margin-top: 20px; color: #f8f8f8">
                </div>


                <h2>Payment Gateway</h2>
                <form method="post" action="CreatePaymentDetailServlet?customerId=<%=customer.getId()%>">
                    <div class="form">
                        <div class="card space icon-relative">
                            <label class="label">Card holder:</label>
                            <input type="text" name="cardholderName" class="input" placeholder="Cardholder Name" required>
                            <i class="fas fa-user"></i>
                        </div>

                        <div class="breaks"> </div>
                        <div class="card space icon-relative" style="background-color: #f8f8f8;">
                            <label class="label">Card number:</label>
                            <input type="text" name="cardNumber" class="input" data-mask="0000 0000 0000 0000" placeholder="Card Number" required>
                            <i class="far fa-credit-card"></i>
                        </div>
                        <div class="breaks"> </div>
                        <div class="card-grp space">
                            <div class="card-item icon-relative">
                                <label class="label">Expiry date:</label>
                                <input type="text" name="expiryDate" class="input" data-mask="00 / 00"  placeholder="00 / 00" required>
                                <i class="far fa-calendar-alt"></i>
                            </div>
                            <div class="breaks"> </div>
                            <div class="card-item icon-relative">
                                <label class="label">CVC:</label>
                                <input type="text"  name="cvc" class="input" data-mask="000" placeholder="000" required>
                                <i class="fas fa-lock"></i>

                            </div>
                        </div>
                        <div class="breaks"> </div>
                         <button type="submit" class="btns" style="background-color: #5bdc9f; border: 0px; padding: 12px; width:100%; font-size: 16px">
                              Save Payment 
                            </button> 
                        </form>
                        <div style="padding-bottom: 10px; background-color: #f8f8f8"> </div>


                        <a href="PaymentDetailServlet?customerId=<%=customer.getId()%>"><div class="btn" style="background-color: #dddddd; color: #24252A">
                                Go Back
                            </div></a>

                    </div>
                
            </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js" integrity="sha512-pHVGpX7F/27yZ0ISY+VVjyULApbDlD0/X0rgGbTqCE7WFW5MezNTWG/dnhtbBuICzsd0WQPgpE4REBLv+UqChw==" crossorigin="anonymous"></script>
    </body>
</html>
