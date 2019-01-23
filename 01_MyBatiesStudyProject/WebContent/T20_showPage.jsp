<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- 核心標簽 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T20_showPage.jsp</title>
</head>
<body>
	<h3>T20_showPage.jsp</h3><hr>
	<a href="T21_CreateUser.jsp">建立用戶</a>
	<table>
		<tr>
			<th>uid</th>
			<th>uname</th>
			<th>password</th>
			<th>gender</th>
			<th>age</th>
		</tr>
		
		<c:forEach items="${pageInfo.list}" var="user">
			<tr>
				<td>${user.uid}</td>
				<td>${user.uname}</td>
				<td>${user.password}</td>
				<td>${user.gender}</td>
				<td>${user.age}</td>
			</tr>
		</c:forEach>
	</table>
	<a 
		href="20_test?pageStart=${pageInfo.pageStart-1}&pageSize=${PageInfo.pageSize}"
		<c:if test="${pageInfo.pageStart<=1}">
			onclick="javascript:return false"
		</c:if>
	>
		上一頁
	</a>
	<a href="20_test?pageStart=${pageInfo.pageStart+1}&pageSize=${PageInfo.pageSize}">下一頁</a>

</body>
</html>