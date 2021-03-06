<%@ page import="org.example.constans.Attributes" %><%--
  Created by IntelliJ IDEA.
  User: павел
  Date: 25.12.2020
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Set Salary</title>
    <style>
        <%@include file="/pages/style.css" %>
    </style>
</head>
<body>
<%= session.getAttribute(Attributes.TEACHERS)%><br/>
<h3>Enter teacher's login and his salary:</h3>
<form method="post" action="<c:url value="/setSalary"/>">
    <input type="number" required placeholder="id" name="idTeacher"><br/>
    <input type="number" required placeholder="salary" name="salaryTeacher"><br/>
    <input class="button" type="submit" value="Set salary">
</form>
<a href="<c:url value='/pages/AdminPage.jsp' />">Back</a><br/>
<form method="post" action="<c:url value="/logout"/>">
    <input class="button" type="submit" value="LogoutButton">
</form>
</body>
</html>
