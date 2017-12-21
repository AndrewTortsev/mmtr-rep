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
    <form action="javascript:void(null);" id="controlForm">
        <tr>
            <th>*</th>

            <th><input type="text" name="f1"></th>
            <th><input type="text" name="f2"></th>
            <th><input type="text" name="f3"></th>

            <th>
                <button class="add">Add</button>
            </th>
        </tr>
    </form>
    <div id="data">
        <jsp:include page="list.jsp"/>
    </div>
    <script>

        $(function () {
            loadTable();
            $('button.add, button.save').on("click", function () {
                addRow();
            });
        })
    </script>
</div>
<div id="getResultDiv"></div>
</body>
</html>