<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 05.10.2022
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pl">
  <head>
    <title>Błąd logowania</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../style.css">
  </head>
  <body>
    <h1>Błąd logowania</h1>
    <p>Wprowadzono błędną nazwę użytkownika lub hasło.</p>
    <a href="${pageContext.request.contextPath}/">Wróć do strony głównej</a>
  <script>
    setInterval(function(){
      location.reload(true);
    },5*60*1000);
  </script>
  </body>
</html>
