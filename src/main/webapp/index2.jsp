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
<style>

    .thumbnail {
        position: relative;
        width: 100px;
        height: 100px;
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
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="/">Ads</a>

    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="/">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/add.jsp">Add advertisement</a>
        </li>
    </ul>
</nav>
<div class="container" style="align-content: center">


    <div class="container">
        <h1 class="text-primary" style="text-align:center">All advertisements:</h1><br>

        <div class="row">


            <c:set var="count" value="0" scope="page"/>
            <c:forEach items="${categoriesPaged}" var="category">
                <div class="col-sm-3">

                    <table class="table">
                        <tbody>

                        <tr>
                            <td rowspan="2">
                                <div class="thumbnail">
                                    <img src="${category.getImage().getPath()}${category.getImage().getName()}"
                                         alt="Image"/>
                                </div>
                            </td>
                            <td>
                                    ${category.getId()}
                            </td>
                        </tr>

                        <tr>
                            <td>
                                    ${category.getName()}
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </div>
                <c:set var="count" value="${count + 1}" scope="page"/>

                <c:if test="${count == 4 }">
                    <br>
                    <c:set var="count" value="0" scope="page"/>
                </c:if>
            </c:forEach>

        </div>
    </div>
    <div class="row">
        <table style="border-spacing: 10px 5px">
            <tr>
                <c:forEach begin="1" end="${(categoriesAll.size()+2)/8}" varStatus="loop">
                    <td>
                        <a href="/?page=${loop.index}">${loop.index}</a>
                    </td>
                </c:forEach>
            </tr>
        </table>

    </div>
</div>
</body>
</html>
