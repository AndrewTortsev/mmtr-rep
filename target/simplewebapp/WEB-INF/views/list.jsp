<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <%--@elvariable id="rows" type="java.util.List<tutorial.TEST>"--%>
    <c:forEach items="${rows}" var="row">
        <tr>
            <td data-name="id">${row.id}</td>
            <td data-name="f1">${row.f1}</td>
            <td data-name="f2">${row.f2}</td>
            <td data-name="f3">${row.f3}</td>
            <th>
                <button class="edit" id="edit${row.id}">Edit</button>
            </th>
            <th>
                <button class="delete" id="delete${row.id}">Delete</button>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script>
    $(setEvents());
</script>