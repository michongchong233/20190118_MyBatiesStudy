<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- 核心標簽 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>userList.jsp</title>
</head>
<body>
	<h3>userList.jsp</h3><hr>
	<table>
		<tr>
			<th>id</th>
			<th>username</th>
			<th>password</th>
		</tr>
		<c:forEach items="#{users }" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.username }</td>
				<td>${user.password }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>