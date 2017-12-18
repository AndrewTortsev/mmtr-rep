<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.1.1.js"></script>

    <script type="text/javascript">
        function testClick(value) {
            $("h1").text = value;
        }
    </script>
    <%-- <script type="text/javascript">
         $(document).ready(function setFields(id, f1, f2, f3) {
             $("#id").val(id);
             $("#f1").val(f1);
             $("#f2").val(f2);
             $("#f3").val(f3);
         });
     </script>--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>simple app</title>
    <link rel="stylesheet" type="text/css" href="indexStyle.css">
</head>
<body>
<h1 id="title">TEST02</h1>

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
            <th><input type="text" name="f1" value="${row.f1}"></th>
            <th><input type="text" name="f2" value="${row.f2}"></th>
            <th><input type="text" name="f4" value="${row.f3}"></th>
            <th>
                <button id="edit">Edit</button>
            </th>
            <th>
                <button id="delete">Delete</button>
            </th>
        </tr>
    </c:forEach>
    <tr>
        <th>*</th>
        <th><input type="text" name="f1"></th>
        <th><input type="text" name="f2"></th>
        <th><input type="text" name="f4"></th>
        <td>
            <button id="add">Add</button>
        </td>
    </tr>
    </tbody>
</table>
<script>

    $(function () {
        $("button").on("click", function () {
            testClick($(this).text);
        });
    })
</script>
</body>
</html>