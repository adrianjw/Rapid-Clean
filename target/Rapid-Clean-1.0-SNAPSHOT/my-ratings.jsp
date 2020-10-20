<%@page import="com.uts.rapid.clean.model.dao.RatingDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html class="rating__html">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ratings</title>
        <link rel="stylesheet" type="text/css" href="css/rating-system.css"/>
                <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
          $(function(){
          $("#nav-placeholder").load("cleaner-navigationbar.jsp");
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
        <c:forEach var="rate" items="${listRatings}">
            <div class="rating-masonry__item">

                <p style="background-color: #24252A;" id="wingdings">
                    <c:choose>
                        <c:when test="${rate.rating == 5}">
                            «««««
                        </c:when>
                        <c:when test="${rate.rating == 4}">
                            ««««
                        </c:when>
                        <c:when test="${rate.rating == 3}">
                            «««
                        </c:when>
                        <c:when test="${rate.rating == 2}">
                            ««
                        </c:when>
                        <c:when test="${rate.rating == 1}">
                            «
                        </c:when>
                    </c:choose>
                </p>
                <p style="background-color: #24252A;" id="rating-username">#<c:out value="${rate.customerId}"/></p>
                <hr>
                <p style="background-color: #24252A;">"<c:out value="${rate.comment}"/>"</p>

            </div>
        </c:forEach>
        </div>
    </body>
</html>
