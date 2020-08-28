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
          $("#nav-placeholder").load("navigationbar.jsp");
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
                <p id="wingdings">«««««</p>
                <p id="rating-username">Aurelius Alluvi</p>
                <hr>
                <p>"Cleaner was amazing in the fact that the dining looks really inviting. An amazing job."</p>
            </div>
            <div class="rating-masonry__item">
                <p id="wingdings">««««</p>
                <p id="rating-username">Cannis Major</p>
                <hr>
                <p>"They did a really impressive job. Impressive even to my guests I had that night."</p>
            </div>
            <div class="rating-masonry__item">
                <p id="wingdings">«««««</p>
                <p id="rating-username">Ragnoir Vaseirus</p>
                <hr>
                <p>"I have to say, as a person who lives in my bedroom 75% of the day, finally getting an excellent cleaner on it's case really got the room brightened up. She made sure to put the things I've requested to be moved in the right areas, bookshelves dusted to breathable and the floor ridden from it's sticky demise *cough* can't help spilt coke *cough* and it's smelling superb. All services completed as marked and customer service is affable. Highly recommend this cleaner."</p>
            </div>
            <div class="rating-masonry__item">
                <p id="wingdings">««</p>
                <p id="rating-username">Karen</p>
                <hr>
                <p>"From what I've heard, the cleaner I booked was pretty good. Seem like today wasn't their day. Amateur cleaning. I could probably do a better job if I had the time. Why does these services exist anyway."</p>
            </div>
            <div class="rating-masonry__item">
                <p id="wingdings">«««««</p>
                <p id="rating-username">Anonymous</p>
                <hr>
                <p>"You dear, you are the best cleaner! Everything's just perfect!"</p>
            </div>
            <div class="rating-masonry__item">
                <p id="wingdings">«««</p>
                <p id="rating-username">Jason Filtch</p>
                <hr>
                <p>"The service was moderate. The space is breathable. Very fast and good service. Friendly staff. Easy booking."</p>
            </div>
        </div>
    </body>
</html>
