<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href ="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
    <title>List ToDos Page</title>
</head>
<body>
<div class = "container">
    <h1>Your Todos </h1>
    <table class ="table">
        <thead>
            <th>id</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Status</th>
        </thead>
        <tbody>
        <c:forEach items ="${todos}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
    <a href = "add-todo" class = "btn btn-success">Add Task</a>
</div>
<script src ="webjars\bootstrap\5.1.3\js\bootstrap.bundle.min.js"></script>
<script src ="webjars\jquery\3.6.0\jquery.min.js"></script>
</body>
</html>