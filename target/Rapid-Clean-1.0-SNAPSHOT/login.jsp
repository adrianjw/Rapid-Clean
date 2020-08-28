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
        <title>Login</title>
    </head>
    <body style="background-color: #51abff">
        <form action="" method="POST">
            <table>
                <tr>
                    <td>Email</td>
                    <td><input type="email" name="email"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"></td>
                </tr>
            </table>
        </form>
        <a href="home.jsp"><button class="button button2" type="submit"> Login </button></a>
        <a href="index.jsp"><button class="button button2"> Go Back </button></a>
    </body>
</html>
