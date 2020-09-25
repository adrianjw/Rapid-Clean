<%@page import="java.util.Date"%>
<%@page import="org.bson.types.ObjectId"%>
<%@page import="com.uts.rapid.clean.model.Rating"%>
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
        <%
            // Test data
            Rating rating = new Rating("5f6ab3cbc3536b4d9a1bd42e","5f6bdf17304e6ba9c89f1c26","5f6bdf25304e6ba9c89f1c27",4,"Good service!",new Date());
        %>
    </head>
    <body class="rating__bd">
        <div id="nav-placeholder"></div>
        <form style="background-color: #1a1a1a;" method="POST" action="UpdateRatingServlet">
            
            <h1 id="rating-h1">Leave a Rating!</h1>
            <table class="rating-stars__tb center">
                <tr>
                    <td style="padding-top: 3%;">
                        <div class="rate-stars">
                            <input type="radio" name="rating" id="star1" value="5" <% if (rating.getRating()==5){ %>checked<% } %>><label for="star1"> </label>
                            <input type="radio" name="rating" id="star2" value="4" <% if (rating.getRating()==4){ %>checked<% } %>><label for="star2"> </label>
                            <input type="radio" name="rating" id="star3" value="3" <% if (rating.getRating()==3){ %>checked<% } %>><label for="star3"> </label>
                            <input type="radio" name="rating" id="star4" value="2" <% if (rating.getRating()==2){ %>checked<% } %>><label for="star4"> </label>
                            <input type="radio" name="rating" id="star5" value="1" <% if (rating.getRating()==1){ %>checked<% } %>><label for="star5"> </label>
                        </div>
                    </td>
                </tr>
                <tr>

                    <td style="padding-top: 3%;">
                        <p>Comments: </p>
                        <textarea rows="10" name="comment" class="rating-comment"><%= rating.getComment() %></textarea>
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