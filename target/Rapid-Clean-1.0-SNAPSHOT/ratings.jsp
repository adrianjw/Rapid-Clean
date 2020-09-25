<%-- 
    Document   : ratings (customer)
    Created on : 17/08/2020, 6:07:46 PM
    Author     : Sandy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="rating__html">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ratings</title>
        <link rel="stylesheet" type="text/css" href="css/ratingtickets.css"/>
                <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
          $(function(){
          $("#nav-placeholder").load("cleanernavigationbar.jsp");
          });
        </script>
    </head>
    <body class="rating__bd">
        
        <!-- Navigation Bar -->
        <div id="nav-placeholder"></div>
        
        <!-- Reviews and Ratings Filter Form -->
        
        <form class="ratings-filter__form">
        <h1 id="rating-h1">Reviews & Ratings</h1>
            <table class="rating-filter center">
                <tr>
                    <th>Search: </th>
                    <td><input class="rating-criteria" type="text"></td>
                    <td><button>Apply</button></td>
                </tr>
                <tr>
                    <th>Sort: </th>
                    <td>By Rating</td>
                    <td>By Date Created</td>
                </tr>
            </table>
        </form>
        <br>
        
        <!-- Ratings List Display -->
        <!-- Each <div class="rating-masonry__item"> is a rating/review. -->
        
        <div class="rating-masonry center">

            <div class="rating-masonry__item">
                <c:forEach var="rate" items="${allRatings}">
                <p id="wingdings"><c:out value="${rate.rating}"/></p>
                <p id="rating-username"></p>
                <hr>
                <p>"<c:out value="${rate.comment}"/>"</p>
                <c:forEach/>
            </div>

        </div>
    </body>
</html>
