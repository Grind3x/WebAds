<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Advertisements service - ${advertisement.getTitle()}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<style>

    .thumbnail {
        position: relative;
        width: 250px;
        height: 250px;
        overflow: hidden;
    }

    .thumbnail img {
        position: absolute;
        left: 50%;
        top: 50%;
        height: 100%;
        width: auto;
        -webkit-transform: translate(-50%, -50%);
        -ms-transform: translate(-50%, -50%);
        transform: translate(-50%, -50%);
    }

    .thumbnail img.portrait {
        width: 100%;
        height: auto;
    }

</style>
<body>

<div class="container" style="align-content: center">
    <h1 class="text-primary" style="text-align:center">Advertisement service</h1>
    <br>
    <div class="form-row text-center">
        <div class="col12">
            <br><br>
            <div class="thumbnail">
                <img src="${advertisement.getImage().getPath()}${advertisement.getImage().getName()}"
                     alt="Image"/>
            </div><br>
            Title: ${advertisement.getTitle()}<br>
            Id: ${advertisement.getId()}<br>
            Author: ${advertisement.getAuthor().getName()}<br>
            Text: ${advertisement.getText()}<br>


        </div>
    </div>
</div>
</body>
</html>
