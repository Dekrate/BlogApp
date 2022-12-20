<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 30.09.2022
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Zarejestruj się</title>
    <link rel="stylesheet" href="style.css">
    <meta charset="UTF-8">
</head>
<body>
<% if (request.getSession().getAttribute("username") != null) {
  response.sendRedirect(request.getContextPath() + "/index");
}%>
  <div class="container">
    <h1>Rejestracja</h1>
    <p>Wypełnij formularz, aby założyć konto w serwisie!</p>
    <hr>
    <form action="register" method="post">
      <label for="username"><b>Nazwa użytkownika</b></label><br>
      <input type="text" placeholder="" name="username" id="username" required>
      <br>
      <label for="email"><b>Email</b></label><br>
      <input type="email" placeholder="" pattern="^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$" name="email" id="email" required>
      <br>
      <label for="password"><b>Hasło</b></label><br>
      <input type="password" placeholder="" name="password" id="password" required>
      <hr>
      <p>Zakładając konto akceptujesz <a href="#">regulamin</a>.</p>

      <button type="submit" class="button purplefade">Zarejestruj</button>
      <br>
      <p>Posiadasz już konto? <a href="${pageContext.request.contextPath}/login">Zaloguj się!</a></p>

    </form>
  </div>
  <script>
    function validateEmail(email) {

    }
  </script>
</body>
</html>
