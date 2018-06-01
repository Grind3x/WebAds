<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>All advertisements</title>
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
        width: 150px;
        height: 150px;
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

<div class="container">
    <h1 class="text-primary" style="text-align:center">All advertisements:</h1>
    <table class="table">
        <tbody>
        <c:forEach items="${advertisements}" var="advertisement">

            <tr>
                <td rowspan="5">
                    <div class="thumbnail">
                        <img src="${advertisement.getImage().getPath()}${advertisement.getImage().getName()}"
                             alt="Image"/>
                    </div>
                <td>Title: <a href="adv?id=${advertisement.getId()}"><c:out
                        value="${advertisement.getTitle()}"></c:out></a>
                </td>
            </tr>
            <tr>
                <td>
                    <c:out value="Id: ${advertisement.getId()}"></c:out>
                </td>
            </tr>

            <tr>
                <td>Author: <a href="view?author=${advertisement.getAuthor().getName()}"><c:out
                        value="${advertisement.getAuthor().getName()}"></c:out></a>
                </td>
            </tr>
            <tr>
                <td>
                    <c:out value="${advertisement.getText()}"></c:out>
                </td>
            </tr>
            <tr>
                <td>
                    <fmt:formatDate value="${advertisement.getCreateDate()}" pattern="dd MMM"/>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="javascript:history.back()">
        <button type="button" class="btn btn-primary ">Go back</button>
    </a><br><br>

</div>
</body>
</html>

