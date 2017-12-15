<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>TEST02</title>
</head>

<body>
<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead" TEST02</span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>id</th>
                <th>f1</th>
                <th>f2</th>
                <th>f3</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${rows}" var="row">
            <tr>
                <th>${row.id}</th>
                <th>${row.f1}</th>
                <th>${row.f2}</th>
                <th>${row.f3}</th>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>