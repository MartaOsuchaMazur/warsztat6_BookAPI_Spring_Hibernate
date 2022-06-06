<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit book</title>
</head>
<body>
<form method="post" action="update">
  <div>
    <label for="id">ID</label>
    <input name="di" id="id" type="number">
  </div>
  <div>
    <label for="isbn">ISBN</label>
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
