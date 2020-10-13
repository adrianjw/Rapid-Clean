<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="rating__html">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
        <link rel="stylesheet" type="text/css" href="css/ratingtickets.css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
          $(function(){
          $("#nav-placeholder").load("navigationbar.jsp");
          });
        </script>
        
    </head>
    <body class="rating__bd">
        <div id="nav-placeholder"></div>
        <form style="background-color: #1a1a1a;" method="POST" action="CreateRatingServlet?orderCompletedId=5f705f19c465d542cfe76870">

            <h1 id="rating-h1">Leave a Rating!</h1>
            <table class="rating-stars__tb center">
                <tr>
                    <td style="padding-top: 3%;">
                        <div class="rate-stars">
                            <input type="radio" name="rating" id="star1" value="5"><label for="star1"> </label>
                            <input type="radio" name="rating" id="star2" value="4"><label for="star2"> </label>
                            <input type="radio" name="rating" id="star3" value="3"><label for="star3"> </label>
                            <input type="radio" name="rating" id="star4" value="2"><label for="star4"> </label>
                            <input type="radio" name="rating" id="star5" value="1"><label for="star5"> </label>
                        </div>
                    </td>
                </tr>
                <tr>

                    <td style="padding-top: 3%;">
                        <p>Comments: </p>
                        <textarea rows="10" name="comment" class="rating-comment"></textarea>
                    </td>
                </tr>
                <tr>
                    <td style="padding-top: 3%;">
                        <a href="home.jsp" style="background-color: #1a1a1a;"><button>Cancel</button></a> 
                        <button>Submit</button>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
