<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add new ads</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1 class="text-primary" style="text-align:center">Add new Ads</h1>

    <c:if test="${success_message ne null}">
        <div class="alert alert-success">
            <c:out value="${success_message}"/>
        </div>
    </c:if>

    <c:if test="${error_message ne null}">
        <div class="alert alert-danger">
            <c:out value="${error_message}"/>
        </div>
    </c:if>

    <form action="/add" method="post">
        <div class="form-group">
            <label for="author">Author:</label>
            <input type="text" class="form-control" id="author" name="author">
        </div>
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" class="form-control" id="title" name="title">
        </div>

        <div class="form-group">
            <label for="text">Text:</label>
            <textarea name="text" class="form-control" id="text"></textarea>
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
        <a href="/">
            <button type="button" class="btn btn-primary">Go back</button>
        </a>

    </form>
</div>
</body>
</html>
