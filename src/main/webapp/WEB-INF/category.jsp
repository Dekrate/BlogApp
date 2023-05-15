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
    <c:if test="${not empty pageContext.request.userPrincipal}">
    <p>Jesteś zalogowany jako ${pageContext.request.userPrincipal.name}</p>

    <c:if test="${requestScope.checkIfAdmin}">
    <p>Przejdź do <a href="admin/index">panelu administracyjnego</a>.</p>
    </c:if>
    </c:if>
    <c:if test="${empty pageContext.request.userPrincipal}">
    <p>Nie masz konta? <a href="${pageContext.request.contextPath}/register.jsp">Zarejestruj się!</a></p>
    </c:if>
    <header>
        <h1>Blog </h1>
        <%--        adres do strony--%>
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

</body>
</html>
