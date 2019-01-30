<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T08_index.jsp</title>
</head>
<body>
	<h3>T08_index.jsp</h3><hr>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>age</th>
			<th>tid</th>
		</tr>
		<c:forEach items="${list}" var="student">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.age}</td>
				<td>${student.tid}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>