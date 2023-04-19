
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
            <c:if test="${not empty pageContext.request.userPrincipal}">
                <p>Jesteś zalogowany jako ${pageContext.request.userPrincipal.name}</p>
            </c:if>
            <c:if test="${empty pageContext.request.userPrincipal}">
                <p>Nie masz konta? <a href="${pageContext.request.contextPath}/register.jsp">Zarejestruj się!</a></p>
            </c:if>
            <c:if test="${empty pageContext.request.userPrincipal}">
                <form action="login">
                    <input type="submit" class="login-button" value="Zaloguj" />
                </form>
            </c:if>
            <c:if test="${not empty pageContext.request.userPrincipal}">
                <form action="logout">
                    <input type="submit" class="login-button" value="Wyloguj" />
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
                <c:if test="${not empty pageContext.request.userPrincipal}">
                    <form method="post" action="addComment?id=${requestScope.id}">
        <%--                obsługa kont użytkowników!--%>
                            <textarea id="comment" name="comment" placeholder="Wprowadź swój komentarz!" class="comment" required>
                            </textarea><br>
                        <button type="submit">
                            Wyślij
                        </button>
                    </form>
                </c:if>
                <c:if test="${empty pageContext.request.userPrincipal}">
                    <p>Aby dodawać komentarze, musisz być zalogowanym.</p>
                </c:if>

                <c:if test="${not empty requestScope.commentsForArticle}">
                    <section class="userComments">
                        <c:forEach var="comment" items="${requestScope.commentsForArticle}">
                            <div class="comment" id="${comment.id}">
                                <h3><c:out value="Autor: ${comment.username}"/></h3>
                                <p><c:out value="Data wysłania: ${comment.dateAndTime}" />
                                </p>
                                <p><c:out value="${comment.content}"/></p>
                            </div>
                        </c:forEach>
                    </section>
                </c:if>
            </c:if>
        </section>
        <p onclick="window.scrollTo({ top: 0, behavior: 'smooth' });">Powróć do góry strony</p>
    </div>
    <script>
    </script>
</body>
</html>