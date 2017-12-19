<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="/resources/scripts/lib.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>simple app</title>
    <link rel="stylesheet" type="text/css" href="/resources/styles/indexStyle.css">

</head>
<body>

<div class="main">
    <h1>TEST02</h1>
    <table>
        <thead class="HE">
        <tr>
            <th>ID</th>
            <th>FIELD01</th>
            <th>FIELD02</th>
            <th>FIELD03</th>
            <th colspan="3"></th>
        </tr>
        </thead>
        <tbody class="TB">
        <c:forEach items="${rows}" var="row">
            <tr>
                <th>${row.id}</th>
                <th><input type="text" name="f1${row.id}" value="${row.f1}"></th>
                <th><input type="text" name="f2${row.id}" value="${row.f2}"></th>
                <th><input type="text" name="f3${row.id}" value="${row.f3}"></th>
                <th>
                    <button id="edit${row.id}">Edit</button>
                </th>
                <th>
                    <button id="delete${row.id}">Delete</button>
                </th>
            </tr>
        </c:forEach>
        <tr>
            <th>*</th>

            <th><input type="text" name="f1"></th>
            <th><input type="text" name="f2"></th>
            <th><input type="text" name="f3"></th>

            <th>
                <button id="add">Add</button>
            </th>
        </tr>
        </tbody>
    </table>
    <script>

        $(function () {
            iniRequest();
            $('button').on("click", function () {
                handeB($(this).attr("id"), $(this));
            });
        })
    </script>
</div>
<div id="getResultDiv"></div>
</body>
</html>