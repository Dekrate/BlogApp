<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 03.10.2022
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Zaloguj się</title>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="style.css">
</head>
<body>
      <% if (request.getSession().getAttribute("username") == null) {
        response.sendRedirect("/index");
      }%>
  <div class="container">
    <h1>Zaloguj się</h1>
    <hr>
    <form action="login" method="post">
      <label for="username"><b>Nazwa użytkownika</b></label><br>
      <input type="text" placeholder="" name="username" id="username" required>
      <br>
      <label for="password"><b>Hasło</b></label><br>
      <input type="password" placeholder="" name="password" id="password" required>
      <hr>

      <button type="submit" class="button purplefade">Zaloguj się</button>
      <br>
      <p>Nie posiadasz jeszcze konta? <a href="register.jsp">Zaloguj się!</a></p>
      <c:if test="requestScope.validation == false">
        <p style="color: red">Wprowadzono niepoprawne dawne. Spróbuj ponownie!</p>
      </c:if>
    </form>
  </div>

</body>
</html>
