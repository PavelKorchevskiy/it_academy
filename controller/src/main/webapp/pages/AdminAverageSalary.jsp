<%@ page import="org.example.constans.Attributes" %><%--
  Created by IntelliJ IDEA.
  User: павел
  Date: 26.12.2020
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Average Salary</title>
    <style>
        <%@include file="/pages/style.css" %>
    </style>
</head>
<body>
<%
    String s = (String) session.getAttribute(Attributes.AVERAGE_SALARY);
    if (s != null) {
        out.println(s);
    }%> <br/>
<form method="post" action="<c:url value="/showSalary"/>">
    <input type="number" required placeholder="Number of months" name="numberOfMonths"><br/><br/>
    <input class="button" type="submit" value="Show salary">
</form>
<a href="<c:url value='/pages/AdminPage.jsp' />">Back</a><br/>
<form method="post" action="<c:url value="/logout"/>">
    <input class="button" type="submit" value="LogoutButton">
</form>
</body>
</html>
