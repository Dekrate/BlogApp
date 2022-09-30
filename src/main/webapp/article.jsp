<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 24.09.2022
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Blog</title>
    <link rel="stylesheet" href="style.css" type="text/css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
<div class="container">

    <header>
        <h1><a href="index">Blog</a> </h1>
        <%--        adres do strony--%>
        <form action="#">
            <input type="submit" class="login-button" value="Zaloguj" />
        </form>
    </header>
    <br>
    <nav>
        <ul>
            <c:forEach items="${requestScope.allCategories}" var="category">
                <li class="button purplefade"><a href="#">${category.categoryName}</a></li>
            </c:forEach>
        </ul>
    </nav>

    <article id="article${requestScope.article.id}">
        <h3>${requestScope.article.title}</h3>
        <p>${requestScope.article.content}</p>
    </article>
    
    <section id="comments" class="comments">
        <c:if test="${requestScope.article != null}">
            <h3>Komentarze</h3>
            <c:if test="${requestScope.commentsForArticle == null}">
                <p>Brak komentarzy. Bądź pierwszy!</p>
            </c:if>
            <form method="post" action="addComment">
<%--                obsługa kont użytkowników!--%>
                    <textarea id="text" placeholder="Wprowadź swój komentarz!" required>
                    </textarea><br>
                <button type="submit">
                    Wyślij
                </button>
            </form>
        </c:if>
    </section>
</div>
</body>
</html>