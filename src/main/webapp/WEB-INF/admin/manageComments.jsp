<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Panel administracyjny</title>
        <link rel="stylesheet" href="../style.css" type="text/css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <form action="admin/manageComments">
            <input type="submit" class="login-button" value="Zarządzaj komentarzami" />
        </form>

        <form action="admin/createPost">
            <input type="submit" class="login-button" value="Utwórz post" />
        </form>
        <h1>Zarządzaj komentarzami</h1>
        <h4>Poniżej możesz usuwać komentarze w artykułach.</h4>
        <c:forEach items="${requestScope.comments}" var="articleComments">
            <c:forEach items="${articleComments}" var="comment">
                <section id="comments" class="comments">
                    <a href="../article?id=${comment.articleId}">Odwiedź artykuł</a>
                    <h4>${comment.username}</h4>
                    <h4>${comment.content}</h4>
                    <form action="deleteComment" method="GET">
                        <input type="hidden"
                               name="id"
                               value="${comment.id}">
                        <input type="submit" class="login-button" value="Usuń komentarz" />
                    </form>
                </section>

            </c:forEach>
        </c:forEach>
    </body>
</html>
