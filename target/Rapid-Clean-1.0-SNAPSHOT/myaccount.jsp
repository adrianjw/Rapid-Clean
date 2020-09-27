<%@page import="java.lang.String"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.uts.rapid.clean.model.dao.*"%>
<%@page import="com.uts.rapid.clean.model.dao.*"%>
<%@page import="com.uts.rapid.clean.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script>
          $(function(){
          $("#nav-placeholder").load("navigationbar.jsp");
          });
        </script>
        <title>My Account</title>
        <link href="css/UserAccount.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%
           Customer customer = new Customer ("5f69e1da84ebe990acfef9d6","John","Doe","password123","johndoe@gmail.com","0123412333");
           session.setAttribute("customer", customer);

        
        %>
        <div id="nav-placeholder"></div>
        <header>

  <!-- Identity details -->
  <section class="profileHeader">
    <h1>Hello <%customer.getFirstName();%></h1>
  </section>
  <!-- Links to Social network accounts -->

</header>
<!-- content -->
<section class="mainContent"> 
  <!-- Contact details -->
  <section class="section1">
    <h2 class="sectionTitle">Personal Information</h2>
    <hr class="sectionTitleRule">
    <hr class="sectionTitleRule2">
    <div class="section1Content">
      <p><span>First Name :<%//customer.getFirstName();%></span></p>
      <p><span>Last Name  :<%//customer.getLastName();%></span></p>
      <p><span>Email      :<%//customer.getEmail();%></span></p>
      <p><span>Phone      :<%//customer.getPhoneNumber();%></span></p>
    </div>
  </section>
  <!-- Previous experience details -->
  </section>
<a href="editcustomer.jsp"><button class="button"> Edit </button></a>
    </body>
</html>

