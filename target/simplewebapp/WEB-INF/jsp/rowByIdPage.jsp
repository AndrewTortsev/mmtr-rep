<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h1>Edit day</h1>
<c:url var="saveUrl" value="/?id=${dayAttribute.id}"/>
<%--@elvariable id="dayAttribute" type=""--%>
<form:form modelAttribute="dayAttribute" method="POST" action=${saveUrl}">
    <table>
        <tr>
            <td><form:label path="id">Id:</form:label></td>
            <td><form:input path="id" disabled="true"/></td>
        </tr>

        <tr>
            <td><form:label path="dayDate">First Name:</form:label></td>
            <td><form:input path="dayDate"/></td>
        </tr>

        <tr>
            <td><form:label path="isWork">Last Name</form:label></td>
            <td><form:input path="isWork"/></td>
        </tr>

    </table>

    <input type="submit" value="Save"/>
</form:form>

</body>
</html>