<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Blog</title>
<%--    <link rel="stylesheet" href="style.css" type="text/css">--%>
    <meta charset="UTF-8">

</head>
<body>
    <header>
        <h1>Blog </h1>
    </header>
    <nav>
        <c:forEach items="categories" var="category">
            <p>   <c:out value="${category.getCategoryName()}"/></p>
        </c:forEach>
    </nav>

    <%--posty w kategorii--%>
    <%--   będzie to pętla sekcji--%>
    <article class="">

    </article>
    </body>
</html>