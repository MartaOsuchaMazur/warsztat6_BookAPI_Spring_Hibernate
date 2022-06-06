<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add new book</title>
</head>
<body>
<form method="post" action="add">
    <div>
        <label for="isbn">ISNB</label>
        <input name="isbn" id="isbn" type="text">
    </div>
    <div>
        <label for="title">Title</label>
        <input name="title" id="title" type="text">
    </div>
    <div>
        <label for="author">Author</label>
        <input name="author" id="author" type="text">
    </div>
    <div>
        <label for="publisher">Publisher</label>
        <input name="publisher" id="publisher" type="text">
    </div>
    <div>
        <label for="type">Type</label>
        <input name="type" id="type" type="text">
    </div>
    <div>
        <input type="submit">
    </div>
</form>
</body>
</html>
