<%--
  Created by IntelliJ IDEA.
  User: Elekber
  Date: 22.08.2019
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/layout.css"/>
</head>
<body>
<div style="text-align: center">

    <form action="ls" method="post">

        <div class="lblDesign"> <label for="usernameId">Username: </label></div> <input type="text" id="usernameId" name="username" /> <br>
        <div class="lblDesign"><label for="passwordId">Password: </label></div>  <input type="text" id="passwordId" name="pwd" /> <br>
        <input type="submit" value="Log In"> &nbsp; <input type="reset" value="Clear">


    </form>

</div>
</body>
</html>
