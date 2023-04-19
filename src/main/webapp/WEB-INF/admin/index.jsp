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
    <h1>Panel administracyjny</h1>
        <form action="manageComments">
            <input type="submit" class="login-button" value="Zarządzaj komentarzami" />
        </form>

        <form action="createPost">
            <input type="submit" class="login-button" value="Utwórz post" />
        </form>
    </body>
</html>
