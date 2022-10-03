<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
            <h1>Blog </h1>
    <%--        adres do strony--%>
            <c:if test="${sessionScope.username == null}">
                <form action="login.jsp">
                    <input type="submit" class="login-button" value="Zaloguj" />
                </form>
            </c:if>
            <c:if test="${sessionScope.username != null}">
                <form action="logout">
                    <input type="submit" class="logout-button" value="Wyloguj" />
                </form>
            </c:if>
        </header>
        <br>
        <nav>
            <ul>
        <c:forEach items="${requestScope.allCategories}" var="category">
                <li class="button purplefade"><a href="#">${category.categoryName}</a></li>
        </c:forEach>
            </ul>
        </nav>

        <%--posty w kategorii--%>
        <%--   będzie to pętla sekcji--%>
        <c:forEach items="${requestScope.allArticles}" var="article">
            <article id="article${article.id}">
                <h3>${article.title}</h3>
                <p>${article.content}</p>
                <a href="article?id=${article.id}">Czytaj artykuł</a>
            </article>
        </c:forEach>

    </div>
    </body>
</html>