<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>orgId</td>
    </tr>
    <c:forEach items="${list}" var="list">
        <tr>
            <th>${list}</th>
            <th>${list.orgID}</th>
        </tr>
    </c:forEach>
</table>
<c:if test="${empty list}">
    There are currently no accounts in the list.
</c:if>
</body>
</html>