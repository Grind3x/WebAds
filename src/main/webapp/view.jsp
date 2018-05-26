<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body>

<div class="container">
    <h1 class="text-primary" style="text-align:center">All advertisements:</h1>
    <table class="table table-hover">
        <thead class="thead-light">
        <tr>
            <th>Author</th>
            <th>Title</th>
            <th>Date</th>
            <th>Text</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${advertisements}" var="advertisement">
            <tr>
                <td>
                    <a href="view?author=${advertisement.getAuthor().getName()}"><c:out value="${advertisement.getAuthor().getName()}"></c:out></a>
                </td>
                <td>
                    <c:out value="${advertisement.getTitle()}"></c:out>
                </td>
                <td>
                    <c:out value="${advertisement.getCreateDate()}"></c:out>
                </td>
                <td>
                    <c:out value="${advertisement.getText()}"></c:out>
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

