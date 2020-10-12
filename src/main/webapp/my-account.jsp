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
        <link href="css/useraccountmgmt.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <form action="LoginServlet" method="GET">
        <%
            //Customer customer = new Customer("123","ad","ad","ad","ad","ad");
            Customer customer = (Customer) session.getAttribute("customer");
            Cleaner cleaner = (Cleaner) session.getAttribute("cleaner");
            Address address = (Address) session.getAttribute("address");
            /*
           String email = request.getParameter("emailErr");
           String password = request.getParameter("passErr");
           CustomerDAO customerDAO = new CustomerDAO();
           customerDAO.findCustomer(email, password);
           Customer customer = (Customer) session.getAttribute("customerDAO");*/
        %>
        <div id="nav-placeholder"></div>
        <header>

  <!-- Identity details -->
  <section class="profileHeader">
    <h1>Hello ${customer.firstName}</h1>
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
      <p><span>First Name :${customer.firstName}</span></p>
      <br>
      <p><span>Last Name  :${customer.lastName}</span></p>
      <br>
      <p><span>Email      :${customer.email}</span></p>
      <br>
      <p><span>Phone      :${customer.phoneNumber}</span></p>
      <br>
    </div>
  </section>
  <section class="section1">
    <h2 class="sectionTitle">Address</h2>
    <hr class="sectionTitleRule">
    <hr class="sectionTitleRule2">
    <div class="section1Content">
      <p><span>Street Address : ${address.streetAddress}</span></p>
      <br>
      <p><span>Suburb : ${address.surburb}</span></p>
      <br>
      <p><span>State : ${address.state}</span></p>
      <br>
      <p><span>Postcode : ${address.postcode}</span></p>
      <br>
    </div>
  </section>
  <!-- Previous experience details -->
  <section class="section1">
    <h2 class="sectionTitle">Billing Details</h2>
    <hr class="sectionTitleRule">
    <hr class="sectionTitleRule2">
    <div class="section1Content">
      <p><span>Card holder name :</span></p>
      <br>
      <p><span>Card Number :</span></p>
      <br>
      <p><span>Expiry Date :</span></p>
      <br>
    </div>
    </section>
  <!-- Previous experience details -->
  </section>
    <a href="editcustomer.jsp"><button class="button" type="button"> Edit </button></a>
    <% if (customer != null) { %>
        <a href="DeleteAccountServlet?id=<%=customer.getId()%>"><button class="button" type="button"> Delete Account </button></a>
    <% } %>
    <% if (cleaner != null) { %>
        <a href="DeleteAccountServlet?id=<%=cleaner.getId()%>"><button class="button" type="button"> Delete Account </button></a>
    <% } %>
    </form>
        </body>
</html>
