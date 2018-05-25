<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1 class="text-primary" style="text-align:center">Advertisement service</h1>
    <br>
    <div class="form-row text-center">
        <div class="col-12">
            <img class="img-fluid" src="/img/1.jpg" class="rounded">


            <br><br>
            <a href="add.jsp" style="text-align:center">
                <button type="button" class="btn btn-outline-success btn align-middle">Add advertisement</button>
            </a>
            <a href="view" style="text-align:center">
                <button type="button" class="btn btn-outline-primary btn align-middle">List all advertisements</button>
            </a>
        </div>
    </div>


</div>
</body>
</html>
