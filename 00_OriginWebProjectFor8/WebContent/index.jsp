<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- 核心標簽 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select All User</title>
</head>
<body>
<h3>Select All User</h3><hr>
<table>
	<tr>
		<th>uid</th>
		<th>uname</th>
		<th>password</th>
		<th>gender</th>
		<th>age</th>
	</tr>
	<c:forEach items="${userList}" var="user">
		<tr>
			<td>${user.uid}</td>
			<td>${user.uname}</td>
			<td>${user.password}</td>
			<td>${user.gender}</td>
			<td>${user.age}</td>
		</tr>
	</c:forEach>
</table>
<a href="/create.jsp">Create User</a>

</body>
</html>