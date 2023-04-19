<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dodaj post</title>
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

    <form action="uploadPost" method="post">
        <label for="title">Tytuł:</label><br>
        <input type="text" id="title" name="title" required><br>
        <label for="content">Treść:</label><br>
        <textarea id="content" name="content" required></textarea><br>
        <label for="category">Kategoria:</label><br>
        <select id="category" name="category">
            <option value="1">Z kraju</option>
            <option value="2">Ze świata</option>
        </select><br>
        <input type="submit" value="Dodaj post">
    </form>
</body>
</html>
